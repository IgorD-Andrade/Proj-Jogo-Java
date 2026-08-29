package missao;

/**
 * Direcoes de movimento da nave, com a tecla e o vetor de deslocamento.
 *
 * Concentrar o vetor aqui evita espalhar if/else pelo codigo e mantem
 * compatibilidade com os metodos originais moveUp/moveDown/moveLeft/moveRight.
 */
public enum Direcao {

    CIMA('W', 0, -1),
    BAIXO('S', 0, 1),
    ESQUERDA('A', -1, 0),
    DIREITA('D', 1, 0);

    private final char tecla;
    private final int deltaX;
    private final int deltaY;

    Direcao(char tecla, int deltaX, int deltaY) {
        this.tecla = tecla;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public char getTecla() {
        return tecla;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    /** Retorna a direcao da tecla informada ou null se o comando nao for de movimento. */
    public static Direcao porTecla(char tecla) {
        char maiuscula = Character.toUpperCase(tecla);
        for (Direcao direcao : values()) {
            if (direcao.tecla == maiuscula) {
                return direcao;
            }
        }
        return null;
    }
}
