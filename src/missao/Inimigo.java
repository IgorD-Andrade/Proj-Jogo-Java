package missao;

/**
 * Exercicio 7 - Inimigo dinamico.
 *
 * A classe nao implementa nenhum algoritmo de deslocamento: delega a decisao
 * para uma EstrategiaMovimento (Strategy), mantendo baixo acoplamento.
 * A verificacao de colisao segue o mesmo contrato do Asteroide original.
 */
public class Inimigo {

    private final String identificacao;
    private final EstrategiaMovimento estrategiaMovimento;
    private int x;
    private int y;

    public Inimigo(String identificacao, int x, int y, EstrategiaMovimento estrategiaMovimento) {
        this.identificacao = identificacao;
        this.x = x;
        this.y = y;
        this.estrategiaMovimento = estrategiaMovimento;
    }

    public String getIdentificacao() { return identificacao; }
    public int getX() { return x; }
    public int getY() { return y; }

    public void mover(Mapa mapa) {
        int[] destino = estrategiaMovimento.proximaPosicao(x, y, mapa);
        this.x = destino[0];
        this.y = destino[1];
    }

    public boolean colideCom(Nave n) {
        return n.getX() == x && n.getY() == y;
    }

    public char getSimbolo() {
        return Simbolos.INIMIGO;
    }
}
