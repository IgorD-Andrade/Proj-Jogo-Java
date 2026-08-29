package missao;

/**
 * Exercicio 3 - Customizacao Visual.
 *
 * Ponto unico de configuracao dos simbolos do mapa. Na base original a nave era
 * 'N' e o asteroide 'A'; aqui a nave virou '^' e o asteroide '@', liberando a
 * letra 'A' para o novo Astronauta.
 *
 * Alterar a aparencia do jogo exige mudar somente esta classe (Open/Closed).
 */
public final class Simbolos {

    public static final char NAVE = '^';
    public static final char PROFESSOR = 'P';
    public static final char ENGENHEIRO = 'E';
    public static final char ASTRONAUTA = 'A';
    public static final char ASTEROIDE = '@';
    public static final char INIMIGO = '#';
    public static final char PLATAFORMA = 'L';
    public static final char VAZIO = '.';

    private Simbolos() {
    }
}
