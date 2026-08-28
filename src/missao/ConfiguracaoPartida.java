package missao;

/**
 * Parametros de uma fase da campanha: piloto, setor (exercicio 6),
 * dificuldade (exercicio 8), fase atual e o que a nave traz da fase anterior
 * (vidas e pontuacao acumulada).
 *
 * Objeto imutavel: depois de criado, as regras daquela fase nao mudam.
 */
public class ConfiguracaoPartida {

    private final String piloto;
    private final Mapa mapa;
    private final Dificuldade dificuldade;
    private final Fase fase;
    private final int vidasIniciais;
    private final int pontuacaoInicial;

    public ConfiguracaoPartida(String piloto, Mapa mapa, Dificuldade dificuldade, Fase fase,
                               int vidasIniciais, int pontuacaoInicial) {
        this.piloto = piloto;
        this.mapa = mapa;
        this.dificuldade = dificuldade;
        this.fase = fase;
        this.vidasIniciais = vidasIniciais;
        this.pontuacaoInicial = pontuacaoInicial;
    }

    public String getPiloto() { return piloto; }
    public Mapa getMapa() { return mapa; }
    public Dificuldade getDificuldade() { return dificuldade; }
    public Fase getFase() { return fase; }
    public int getVidasIniciais() { return vidasIniciais; }
    public int getPontuacaoInicial() { return pontuacaoInicial; }

    /**
     * Exercicio 1 - a capacidade da nave e derivada da carga da fase,
     * garantindo que toda a tripulacao caiba a bordo.
     */
    public int getCapacidadeNave() {
        return fase.passageirosPara(dificuldade);
    }
}
