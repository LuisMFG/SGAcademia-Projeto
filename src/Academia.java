import java.util.ArrayList;
import java.util.List;

// Classe que representa a entidade da academia, contendo informações sobre pessoas e fichas de academia
public class Academia {
    // Lista de pessoas cadastradas na academia (clientes, treinadores, instrutores e funcionários)
    private List<Pessoa> pessoas;
    
    // Lista de fichas de academia criadas na academia
    private List<FichaAcademia> fichas;
    
    // Referência para a pessoa (funcionário) que está atualmente logada no sistema
    private Pessoa funcionarioLogado;

    // Construtor que inicializa as listas de pessoas e fichas ao instanciar a academia
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

    // Método para realizar o login de um funcionário na academia
    public boolean loginFuncionario(String login, String senha) {
        // Itera sobre a lista de pessoas para encontrar um funcionário com as credenciais fornecidas
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                // Verifica se as credenciais correspondem a um funcionário
                if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
                    // Define o funcionário logado
                    funcionarioLogado = funcionario;
                    // Retorna verdadeiro indicando login bem-sucedido
                    return true;
                }
            }
        }
        // Retorna falso se não encontrar um funcionário com as credenciais fornecidas
        return false;
    }

    // Método para obter a referência do funcionário atualmente logado
    public Pessoa getFuncionarioLogado() {
        return funcionarioLogado;
    }

    // Método para obter a lista de todas as pessoas cadastradas na academia
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    // Método para obter a lista de todas as fichas de academia criadas na academia
    public List<FichaAcademia> getFichas() {
        return fichas;
    }

    // Método de espaço reservado (placeholder) que deve ser implementado para retornar os nomes dos clientes
    public String[] getNomesClientes() {
        return null;
    }
}
