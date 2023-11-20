
// Importa a classe UUID do pacote java.util para gerar identificadores únicos
import java.util.UUID;

// Declaração da classe Pessoa
public class Pessoa {

    // Declaração de variáveis de instância (atributos) da classe Pessoa
    private UUID id;
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String cep;
    private String email;
    private String telefone;
    private String login;
    private String senha;

    // Construtor da classe Pessoa, usado para criar instâncias da classe
    public Pessoa(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha) {
        // Gera um UUID (identificador único universal) para a instância
        this.id = UUID.randomUUID();
        // Inicializa os atributos com os valores passados como parâmetros
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    // Métodos de acesso para obter os valores dos atributos

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Métodos de modificação para alterar os valores dos atributos

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Sobrescrita do método toString para fornecer uma representação de string da
    // instância
    @Override
    public String toString() {
        return "Nome: " + nome + ", ID:" + id;
    }
}
