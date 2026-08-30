package missao;

/**
 * Exercicio 9 - Persistencia expandida.
 *
 * Na base o ranking guardava apenas nome e pontuacao. Agora cada partida
 * registra tambem data/hora, passageiros resgatados, dificuldade e resultado.
 */
public class RegistroPartida {

    private final String piloto;
    private final int pontuacao;
    private final int passageirosResgatados;
    private final int totalPassageiros;
    private final String dificuldade;
    private final String fase;
    private final String resultado;
    private final String dataHora;

    public RegistroPartida(String piloto, int pontuacao, int passageirosResgatados,
                           int totalPassageiros, String dificuldade, String fase,
                           String resultado, String dataHora) {
        this.piloto = piloto;
        this.pontuacao = pontuacao;
        this.passageirosResgatados = passageirosResgatados;
        this.totalPassageiros = totalPassageiros;
        this.dificuldade = dificuldade;
        this.fase = fase;
        this.resultado = resultado;
        this.dataHora = dataHora;
    }

    public String getPiloto() { return piloto; }
    public int getPontuacao() { return pontuacao; }
    public int getPassageirosResgatados() { return passageirosResgatados; }
    public int getTotalPassageiros() { return totalPassageiros; }
    public String getDificuldade() { return dificuldade; }
    /** Ate onde o piloto chegou na campanha (ex.: "2/3"). */
    public String getFase() { return fase; }
    public String getResultado() { return resultado; }
    public String getDataHora() { return dataHora; }
}
