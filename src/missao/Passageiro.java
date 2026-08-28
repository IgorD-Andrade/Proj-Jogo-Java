package missao;

/**
 * Classe base dos tripulantes (mantida do codigo original do professor).
 *
 * Exercicio 4 - Pontuacao polimorfica: foi acrescentado getPontuacao(), que
 * cada subclasse sobrescreve com @Override. O restante do jogo trabalha apenas
 * com o tipo Passageiro (Liskov), portanto criar um novo tipo de tripulante
 * nao exige alterar Nave nem Missao (Open/Closed).
 */
public class Passageiro {

    private String nome;
    private String tipo;
    private int x;
    private int y;

    public Passageiro(String nome, String tipo, int x, int y) {
        this.nome = nome;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getX() { return x; }
    public int getY() { return y; }

    /** Pontos concedidos ao embarcar. Cada subclasse define o seu valor. */
    public int getPontuacao() {
        return 5;
    }

    /** Caractere exibido no mapa. */
    public char getSimbolo() {
        return Simbolos.PROFESSOR;
    }

    public boolean estaEm(int outroX, int outroY) {
        return this.x == outroX && this.y == outroY;
    }

    public String getDescricao() {
        return getTipo() + " " + getNome();
    }
}
