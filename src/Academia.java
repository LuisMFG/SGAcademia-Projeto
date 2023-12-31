import java.util.ArrayList;
import java.util.List;

// Classe que representa a entidade da academia, contendo informações sobre pessoas e fichas de academia
public class Academia {
    // Lista de pessoas cadastradas na academia (clientes, instrutores
    // )
    private List<Pessoa> pessoas;

    // Lista de fichas de academia criadas na academia
    private List<FichaAcademia> fichas;

    // Referência para a pessoa (funcionário) que está atualmente logada no sistema
    private Pessoa Logado;

    // Construtor que inicializa as listas de pessoas e fichas ao instanciar a
    // academia
    public Academia() {
        this.pessoas = new ArrayList<>();
        this.fichas = new ArrayList<>();
    }

    // Método para adicionar uma pessoa à lista de pessoas da academia
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // Método para criar e adicionar uma ficha de academia à lista de fichas
    public void criarFicha(FichaAcademia ficha) {
        fichas.add(ficha);
    }

    // Método para obter a referência do funcionário atualmente logado
    public Pessoa getLogado() {
        return Logado;
    }

    // Método para obter a lista de todas as pessoas cadastradas na academia
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    // Método para obter a lista de todas as fichas de academia criadas na academia
    public List<FichaAcademia> getFichas() {
        return fichas;
    }

    // Metodo para remover ficha
    public void removerFicha(FichaAcademia ficha) {
        fichas.remove(ficha);
    }

}
