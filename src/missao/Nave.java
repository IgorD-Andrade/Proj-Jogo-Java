package missao;

import java.util.ArrayList;
import java.util.List;

/**
 * Nave do piloto (evolucao da classe original do professor).
 *
 * Exercicio 1 - a capacidade continua vindo pelo construtor, mas agora e
 * calculada a partir da carga da missao, comportando todos os passageiros.
 * Exercicio 5 - Sistema de vidas: a nave conhece e controla as proprias vidas.
 *
 * GRASP - Information Expert: quem sabe se ha espaco a bordo e quantas vidas
 * restam e a propria nave.
 */
public class Nave {

    private static final int VIDAS_PADRAO = 3;

    private String id;
    private int x;
    private int y;
    private int capacidade;
    private int vidas;
    private List<Passageiro> passageiros = new ArrayList<>();

    /** Construtor original mantido por compatibilidade com a base. */
    public Nave(String id, int capacidade) {
        this(id, capacidade, VIDAS_PADRAO);
    }

    public Nave(String id, int capacidade, int vidas) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade da nave deve ser positiva.");
        }
        this.id = id;
        this.capacidade = capacidade;
        this.vidas = vidas;
        this.x = 0;
        this.y = 0;
    }

    public String getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getCapacidade() { return capacidade; }
    public int getVidas() { return vidas; }
    public List<Passageiro> getPassageiros() { return passageiros; }

    // Movimentos originais da base.
    public void moveUp() { y--; }
    public void moveDown() { y++; }
    public void moveLeft() { x--; }
    public void moveRight() { x++; }

    /**
     * Movimento validado contra os limites do setor.
     * Retorna false quando a nave tentaria sair do mapa.
     */
    public boolean mover(Direcao direcao, Mapa mapa) {
        int destinoX = x + direcao.getDeltaX();
        int destinoY = y + direcao.getDeltaY();
        if (!mapa.dentroDosLimites(destinoX, destinoY)) {
            return false;
        }
        switch (direcao) {
            case CIMA: moveUp(); break;
            case BAIXO: moveDown(); break;
            case ESQUERDA: moveLeft(); break;
            case DIREITA: moveRight(); break;
            default: break;
        }
        return true;
    }

    public boolean temEspaco() {
        return passageiros.size() < capacidade;
    }

    /** Metodo original: retorna false quando a nave esta lotada. */
    public boolean embarcar(Passageiro p) {
        if (temEspaco()) {
            passageiros.add(p);
            return true;
        }
        return false;
    }

    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    public boolean estaDestruida() {
        return vidas <= 0;
    }

    public boolean estaEm(int outroX, int outroY) {
        return this.x == outroX && this.y == outroY;
    }

    public char getSimbolo() {
        return Simbolos.NAVE;
    }
}
