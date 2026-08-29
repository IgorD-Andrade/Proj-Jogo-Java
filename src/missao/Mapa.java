package missao;

/**
 * Exercicio 6 - Mapa configuravel.
 *
 * A base original tinha os limites fixos (-5 a 5) dentro da classe Main.
 * Agora o setor e um objeto proprio, criado com a dimensao informada pelo
 * jogador, e e ele quem sabe responder se uma coordenada e valida
 * (GRASP - Information Expert).
 */
public class Mapa {

    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    /**
     * @param dimensao quantidade de celulas por lado. Valores pares sao
     *                 ajustados para o impar imediatamente inferior, para que
     *                 o mapa fique centrado na coordenada (0, 0).
     */
    public Mapa(int dimensao) {
        if (dimensao < 3) {
            throw new IllegalArgumentException("O mapa deve ter no minimo 3 celulas por lado.");
        }
        int metade = (dimensao - 1) / 2;
        this.minX = -metade;
        this.maxX = metade;
        this.minY = -metade;
        this.maxY = metade;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    /** Quantidade real de celulas por lado. */
    public int getDimensao() {
        return maxX - minX + 1;
    }

    public int getArea() {
        return getDimensao() * getDimensao();
    }

    public boolean dentroDosLimites(int x, int y) {
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }
}
