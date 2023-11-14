public class Funcionario extends Pessoa {
    private String dataAdmissao;
    private String dataDemissao;
    private double remuneracao;
    private String dataRemuneracao;
    private String expediente;

    public Funcionario(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha,
            String dataAdmissao, String dataDemissao, double remuneracao,
            String dataRemuneracao, String expediente) {
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha);
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.remuneracao = remuneracao;
        this.dataRemuneracao = dataRemuneracao;
        this.expediente = expediente;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getDataRemuneracao() {
        return dataRemuneracao;
    }

    public void setDataRemuneracao(String dataRemuneracao) {
        this.dataRemuneracao = dataRemuneracao;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    @Override
    public String toString() {
        return "Funcionario: " + getNome() + " (Remuneracao: " + remuneracao + ")";
    }
}
