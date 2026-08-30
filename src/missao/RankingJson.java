package missao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementacao do ranking em arquivo JSON (ranking.json), evoluida dos metodos
 * loadRanking/saveRanking/parseRankingJson que estavam na Main original.
 *
 * Single Responsibility Principle: esta classe so entende de arquivo; as regras
 * do jogo ficam em Missao. Escrita e leitura sao feitas na mao, sem bibliotecas
 * externas, para o projeto rodar apenas com javac/java.
 */
public class RankingJson implements RepositorioRanking {

    private final Path arquivo;

    public RankingJson(Path arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public void salvar(RegistroPartida registro) {
        List<RegistroPartida> registros = new ArrayList<>(listar());
        registros.add(registro);
        gravar(registros);
    }

    @Override
    public List<RegistroPartida> listar() {
        List<RegistroPartida> registros = new ArrayList<>();
        if (!Files.exists(arquivo)) {
            return registros;
        }
        try {
            String conteudo = new String(Files.readAllBytes(arquivo), StandardCharsets.UTF_8);
            for (Map<String, String> objeto : lerObjetos(conteudo)) {
                registros.add(new RegistroPartida(
                        texto(objeto, "piloto", "Desconhecido"),
                        inteiro(objeto, "pontuacao", 0),
                        inteiro(objeto, "passageirosResgatados", 0),
                        inteiro(objeto, "totalPassageiros", 0),
                        texto(objeto, "dificuldade", "-"),
                        texto(objeto, "fase", "-"),
                        texto(objeto, "resultado", "-"),
                        texto(objeto, "dataHora", "-")));
            }
        } catch (IOException excecao) {
            System.out.println("Aviso: nao foi possivel ler o ranking (" + excecao.getMessage() + ").");
        }
        registros.sort(Comparator.comparingInt(RegistroPartida::getPontuacao).reversed());
        return registros;
    }

    @Override
    public void limpar() {
        gravar(new ArrayList<RegistroPartida>());
    }

    private void gravar(List<RegistroPartida> registros) {
        StringBuilder json = new StringBuilder("[\n");
        for (int i = 0; i < registros.size(); i++) {
            json.append(converter(registros.get(i)));
            json.append(i < registros.size() - 1 ? ",\n" : "\n");
        }
        json.append("]\n");
        try {
            Files.write(arquivo, json.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException excecao) {
            System.out.println("Nao foi possivel salvar o ranking: " + excecao.getMessage());
        }
    }

    private String converter(RegistroPartida registro) {
        return "  {\n"
                + "    \"piloto\": \"" + escapar(registro.getPiloto()) + "\",\n"
                + "    \"pontuacao\": " + registro.getPontuacao() + ",\n"
                + "    \"passageirosResgatados\": " + registro.getPassageirosResgatados() + ",\n"
                + "    \"totalPassageiros\": " + registro.getTotalPassageiros() + ",\n"
                + "    \"dificuldade\": \"" + escapar(registro.getDificuldade()) + "\",\n"
                + "    \"fase\": \"" + escapar(registro.getFase()) + "\",\n"
                + "    \"resultado\": \"" + escapar(registro.getResultado()) + "\",\n"
                + "    \"dataHora\": \"" + escapar(registro.getDataHora()) + "\"\n"
                + "  }";
    }

    private String escapar(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", " ").replace("\r", "");
    }

    /** Le um array de objetos simples (sem listas nem objetos aninhados). */
    private List<Map<String, String>> lerObjetos(String json) {
        List<Map<String, String>> objetos = new ArrayList<>();
        if (json == null) {
            return objetos;
        }
        int indice = 0;
        int tamanho = json.length();
        while (indice < tamanho) {
            if (json.charAt(indice) != '{') {
                indice++;
                continue;
            }
            Map<String, String> objeto = new LinkedHashMap<>();
            indice++;
            while (indice < tamanho && json.charAt(indice) != '}') {
                while (indice < tamanho && json.charAt(indice) != '"' && json.charAt(indice) != '}') {
                    indice++;
                }
                if (indice >= tamanho || json.charAt(indice) == '}') {
                    break;
                }
                StringBuilder chave = new StringBuilder();
                indice = lerTexto(json, indice, chave);

                while (indice < tamanho && json.charAt(indice) != ':') {
                    indice++;
                }
                indice++;
                while (indice < tamanho && Character.isWhitespace(json.charAt(indice))) {
                    indice++;
                }

                String valor;
                if (indice < tamanho && json.charAt(indice) == '"') {
                    StringBuilder conteudo = new StringBuilder();
                    indice = lerTexto(json, indice, conteudo);
                    valor = conteudo.toString();
                } else {
                    int inicio = indice;
                    while (indice < tamanho && json.charAt(indice) != ','
                            && json.charAt(indice) != '}') {
                        indice++;
                    }
                    valor = json.substring(inicio, indice).trim();
                }
                objeto.put(chave.toString(), valor);

                while (indice < tamanho && (json.charAt(indice) == ','
                        || Character.isWhitespace(json.charAt(indice)))) {
                    indice++;
                }
            }
            objetos.add(objeto);
            indice++;
        }
        return objetos;
    }

    private int lerTexto(String json, int indice, StringBuilder destino) {
        indice++;
        while (indice < json.length()) {
            char caractere = json.charAt(indice);
            if (caractere == '\\' && indice + 1 < json.length()) {
                destino.append(json.charAt(indice + 1));
                indice += 2;
                continue;
            }
            if (caractere == '"') {
                indice++;
                break;
            }
            destino.append(caractere);
            indice++;
        }
        return indice;
    }

    private String texto(Map<String, String> objeto, String chave, String padrao) {
        String valor = objeto.get(chave);
        return valor == null || valor.isEmpty() ? padrao : valor;
    }

    private int inteiro(Map<String, String> objeto, String chave, int padrao) {
        try {
            return Integer.parseInt(texto(objeto, chave, String.valueOf(padrao)));
        } catch (NumberFormatException excecao) {
            return padrao;
        }
    }
}
