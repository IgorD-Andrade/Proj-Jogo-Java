package missao;

import java.util.List;

/**
 * Dependency Inversion Principle: o jogo conhece apenas esta abstracao.
 * Trocar o arquivo JSON por um banco de dados ou por uma API REST no futuro
 * (Spring Boot, na Unidade VII) exige somente uma nova implementacao.
 */
public interface RepositorioRanking {

    void salvar(RegistroPartida registro);

    /** Registros ordenados da maior para a menor pontuacao. */
    List<RegistroPartida> listar();

    /** Exercicio 10 - opcao de resetar o ranking pelo menu principal. */
    void limpar();
}
