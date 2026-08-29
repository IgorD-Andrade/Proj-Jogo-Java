package missao;

/**
 * Exercicio 2 - Nova subclasse de Passageiro.
 *
 * O Astronauta e o tripulante mais valioso da missao (20 pontos) e possui um
 * atributo proprio, a especialidade, demonstrando especializacao alem da
 * simples heranca.
 */
public class Astronauta extends Passageiro {

    private static final int PONTUACAO = 20;

    private final String especialidade;

    public Astronauta(String nome, String especialidade, int x, int y) {
        super(nome, "Astronauta", x, y);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public int getPontuacao() {
        return PONTUACAO;
    }

    @Override
    public char getSimbolo() {
        return Simbolos.ASTRONAUTA;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " (" + especialidade + ")";
    }
}
