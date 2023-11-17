public class Treinador extends Pessoa {
    private double taxaMensalAcademia;

    public Treinador(String nome, String dataNascimento, String endereco, String cep,
                     String email, String telefone, String login, String senha,
                     double taxaMensalAcademia) {
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha);
        this.taxaMensalAcademia = taxaMensalAcademia;
    }

    public double getTaxaMensalAcademia() {
        return taxaMensalAcademia;
    }

    public void setTaxaMensalAcademia(double taxaMensalAcademia) {
        this.taxaMensalAcademia = taxaMensalAcademia;
    }

    @Override
    public String toString() {
        return "Treinador - " + super.toString() + ", Taxa Mensal: " + taxaMensalAcademia;
    }
}
