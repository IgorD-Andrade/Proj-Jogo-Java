package missao;

/**
 * Exercicio 8 - Menu de dificuldades.
 *
 * O enum guarda todos os parametros do nivel: vidas, pontuacao inicial,
 * quantidade de passageiros e de obstaculos. Nenhuma outra classe precisa
 * saber "quantos asteroides tem no dificil" (Information Expert).
 */
public enum Dificuldade {

    FACIL("Facil", 5, 60, 3, 4, 1),
    MEDIO("Medio", 3, 45, 4, 8, 2),
    DIFICIL("Dificil", 2, 30, 6, 14, 4);

    private final String rotulo;
    private final int vidasIniciais;
    private final int pontuacaoInicial;
    private final int quantidadePassageiros;
    private final int quantidadeAsteroides;
    private final int quantidadeInimigos;

    Dificuldade(String rotulo, int vidasIniciais, int pontuacaoInicial,
                int quantidadePassageiros, int quantidadeAsteroides, int quantidadeInimigos) {
        this.rotulo = rotulo;
        this.vidasIniciais = vidasIniciais;
        this.pontuacaoInicial = pontuacaoInicial;
        this.quantidadePassageiros = quantidadePassageiros;
        this.quantidadeAsteroides = quantidadeAsteroides;
        this.quantidadeInimigos = quantidadeInimigos;
    }

    public String getRotulo() {
        return rotulo;
    }

    public int getVidasIniciais() {
        return vidasIniciais;
    }

    public int getPontuacaoInicial() {
        return pontuacaoInicial;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    /** A quantidade de obstaculos e limitada pelo tamanho do mapa escolhido. */
    public int asteroidesPara(Mapa mapa) {
        return Math.min(quantidadeAsteroides, Math.max(1, mapa.getArea() / 8));
    }

    public int inimigosPara(Mapa mapa) {
        return Math.min(quantidadeInimigos, Math.max(1, mapa.getArea() / 20));
    }

    public static Dificuldade porOpcao(int opcao) {
        Dificuldade[] niveis = values();
        if (opcao < 1 || opcao > niveis.length) {
            throw new IllegalArgumentException("Opcao de dificuldade invalida: " + opcao);
        }
        return niveis[opcao - 1];
    }
}
