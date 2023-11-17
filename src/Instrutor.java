// Classe que representa um instrutor da academia, estendendo a classe Funcionario
public class Instrutor extends Funcionario {
    // Atributos específicos de um instrutor
    private String atendimentoDiasSemana; // Dias da semana em que o instrutor realiza atendimentos
    private String atendimentoPeriodo; // Período em que o instrutor realiza atendimentos

    // Construtor que inicializa os atributos da classe e os herdados da classe
    // Funcionario
    public Instrutor(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha,
            String dataAdmissao, String dataDemissao, double remuneracao,
            String dataRemuneracao, String expediente,
            String atendimentoDiasSemana, String atendimentoPeriodo) {
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha,
                dataAdmissao, dataDemissao, remuneracao, dataRemuneracao, expediente);
        this.atendimentoDiasSemana = atendimentoDiasSemana;
        this.atendimentoPeriodo = atendimentoPeriodo;
    }

    // Métodos para acessar e modificar os atributos da classe
    public String getAtendimentoDiasSemana() {
        return atendimentoDiasSemana;
    }

    public void setAtendimentoDiasSemana(String atendimentoDiasSemana) {
        this.atendimentoDiasSemana = atendimentoDiasSemana;
    }

    public String getAtendimentoPeriodo() {
        return atendimentoPeriodo;
    }

    public void setAtendimentoPeriodo(String atendimentoPeriodo) {
        this.atendimentoPeriodo = atendimentoPeriodo;
    }

    // Sobrescrita do método toString para fornecer uma representação em string do
    // objeto
    @Override
    public String toString() {
        return "Instrutor: " + getNome() + " (Atendimento: " + atendimentoDiasSemana + " - " + atendimentoPeriodo + ")";
    }
}
