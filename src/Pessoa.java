// Classe base que representa uma pessoa genérica
public class Pessoa {
    // Atributos que armazenam informações pessoais
    private String nome; // Nome da pessoa
    private String dataNascimento; // Data de nascimento da pessoa
    private String endereco; // Endereço da pessoa
    private String cep; // Código de Endereçamento Postal (CEP)
    private String email; // Endereço de e-mail da pessoa
    private String telefone; // Número de telefone da pessoa
    private String login; // Nome de usuário para login
    private String senha; // Senha para autenticação

    // Construtor que inicializa os atributos da classe
    public Pessoa(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    // Métodos para acessar e modificar os atributos da classe
    public String getNome() {
        return nome;
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
}
