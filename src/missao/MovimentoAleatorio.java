package missao;

import java.util.Random;

/**
 * Exercicio 7 - IA simples: o inimigo sorteia uma direcao a cada turno.
 * Se o sorteio o levaria para fora do setor, ele permanece onde esta.
 */
public class MovimentoAleatorio implements EstrategiaMovimento {

    private final Random aleatorio;

    public MovimentoAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

    @Override
    public int[] proximaPosicao(int x, int y, Mapa mapa) {
        Direcao[] direcoes = Direcao.values();
        Direcao sorteada = direcoes[aleatorio.nextInt(direcoes.length)];
        int destinoX = x + sorteada.getDeltaX();
        int destinoY = y + sorteada.getDeltaY();
        if (!mapa.dentroDosLimites(destinoX, destinoY)) {
            return new int[] {x, y};
        }
        return new int[] {destinoX, destinoY};
    }
}
