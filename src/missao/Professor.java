package missao;

/** Professor: 10 pontos ao ser embarcado. */
public class Professor extends Passageiro {

    private static final int PONTUACAO = 10;

    public Professor(String nome, int x, int y) {
        super(nome, "Professor", x, y);
    }

    @Override
    public int getPontuacao() {
        return PONTUACAO;
    }

    @Override
    public char getSimbolo() {
        return Simbolos.PROFESSOR;
    }
}
