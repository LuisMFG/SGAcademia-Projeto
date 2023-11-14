public class Instrutor extends Funcionario {
    private String atendimentoDiasSemana;
    private String atendimentoPeriodo;

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

    @Override
    public String toString() {
        return "Instrutor: " + getNome() + " (Atendimento: " + atendimentoDiasSemana + " - " + atendimentoPeriodo + ")";
    }
}
