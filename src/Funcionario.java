// Classe que representa um funcionário da academia, estendendo a classe Pessoa
public class Funcionario extends Pessoa {
    // Atributos específicos de um funcionário
    private String dataAdmissao; // Data de admissão do funcionário
    private String dataDemissao; // Data de demissão do funcionário
    private double remuneracao; // Remuneração do funcionário
    private String dataRemuneracao; // Data de pagamento da remuneração
    private String expediente; // Expediente de trabalho do funcionário

    // Construtor que inicializa os atributos da classe e os herdados da classe
    // Pessoa
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

    // Métodos para acessar e modificar os atributos da classe
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

    // Sobrescrita do método toString para fornecer uma representação em string do
    // objeto
    @Override
    public String toString() {
        return "Funcionario: " + getNome() + " (Remuneracao: " + remuneracao + ")";
    }
}
