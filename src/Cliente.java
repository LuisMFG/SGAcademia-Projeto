public class Cliente extends Pessoa {
    private int numeroID;
    private String situacao;
    private String restricoesMedicas;
    private String alteracaoSolicitada;

    public Cliente(String nome, String dataNascimento, String endereco, String cep,
                   String email, String telefone, String login, String senha,
                   int numeroID, String situacao, String restricoesMedicas, String alteracaoSolicitada) {
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha);
        this.numeroID = numeroID;
        this.situacao = situacao;
        this.restricoesMedicas = restricoesMedicas;
        this.alteracaoSolicitada = alteracaoSolicitada;
    }

    

    public int getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(int numeroID) {
        this.numeroID = numeroID;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getRestricoesMedicas() {
        return restricoesMedicas;
    }

    public void setRestricoesMedicas(String restricoesMedicas) {
        this.restricoesMedicas = restricoesMedicas;
    }

    public String getAlteracaoSolicitada() {
        return alteracaoSolicitada;
    }

    public void setAlteracaoSolicitada(String alteracaoSolicitada) {
        this.alteracaoSolicitada = alteracaoSolicitada;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome() + " (Número ID: " + numeroID + ")";
    }
}
