import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Pessoa> pessoas;
    private List<FichaAcademia> fichas;
    private Pessoa funcionarioLogado;

    public Academia() {
        this.pessoas = new ArrayList<>();
        this.fichas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void criarFicha(FichaAcademia ficha) {
        fichas.add(ficha);
    }

    public boolean loginFuncionario(String login, String senha) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pessoa;
                if (funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
                    funcionarioLogado = funcionario;
                    return true;
                }
            }
        }
        return false;
    }

    public Pessoa getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<FichaAcademia> getFichas() {
        return fichas;
    }

    public String[] getNomesClientes() {
        return null;
    }
}
