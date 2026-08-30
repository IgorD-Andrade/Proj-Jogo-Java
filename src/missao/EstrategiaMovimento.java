package missao;

/**
 * Padrao Strategy + Dependency Inversion Principle.
 *
 * O Inimigo depende desta abstracao, e nao de um algoritmo concreto: criar um
 * inimigo que persegue a nave e apenas escrever outra implementacao, sem
 * alterar a classe Inimigo.
 */
public interface EstrategiaMovimento {

    /** Calcula a proxima coordenada. Indice 0 = x, indice 1 = y. */
    int[] proximaPosicao(int x, int y, Mapa mapa);
}
