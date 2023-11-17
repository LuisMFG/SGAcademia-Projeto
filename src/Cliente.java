// Classe que representa um cliente na academia, estendendo a classe Pessoa
public class Cliente extends Pessoa {
    // Número de identificação do cliente
    private int numeroID;

    // Situação do cliente (ex: ativo, inativo, suspenso)
    private String situacao;

    // Restrições médicas do cliente
    private String restricoesMedicas;

    // Alteração solicitada pelo cliente
    private String alteracaoSolicitada;

    // Construtor que inicializa os atributos da classe e chama o construtor da
    // classe pai (Pessoa)
    public Cliente(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha,
            int numeroID, String situacao, String restricoesMedicas, String alteracaoSolicitada) {
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha);
        this.numeroID = numeroID;
        this.situacao = situacao;
        this.restricoesMedicas = restricoesMedicas;
        this.alteracaoSolicitada = alteracaoSolicitada;
    }

    // Método para obter o número de identificação do cliente
    public int getNumeroID() {
        return numeroID;
    }

    // Método para definir o número de identificação do cliente
    public void setNumeroID(int numeroID) {
        this.numeroID = numeroID;
    }

    // Método para obter a situação do cliente
    public String getSituacao() {
        return situacao;
    }

    // Método para definir a situação do cliente
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    // Método para obter as restrições médicas do cliente
    public String getRestricoesMedicas() {
        return restricoesMedicas;
    }

    // Método para definir as restrições médicas do cliente
    public void setRestricoesMedicas(String restricoesMedicas) {
        this.restricoesMedicas = restricoesMedicas;
    }

    // Método para obter a alteração solicitada pelo cliente
    public String getAlteracaoSolicitada() {
        return alteracaoSolicitada;
    }

    // Método para definir a alteração solicitada pelo cliente
    public void setAlteracaoSolicitada(String alteracaoSolicitada) {
        this.alteracaoSolicitada = alteracaoSolicitada;
    }

    // Método que retorna uma representação textual do objeto Cliente
    @Override
    public String toString() {
        return "Cliente: " + getNome() + " (Número ID: " + numeroID + ")";
    }
}