package missao;

/** Engenheiro: 15 pontos ao ser embarcado. */
public class Engenheiro extends Passageiro {

    private static final int PONTUACAO = 15;

    public Engenheiro(String nome, int x, int y) {
        super(nome, "Engenheiro", x, y);
    }

    @Override
    public int getPontuacao() {
        return PONTUACAO;
    }

    @Override
    public char getSimbolo() {
        return Simbolos.ENGENHEIRO;
    }
}
