// Classe que representa um treinador na academia
public class Treinador extends Pessoa {
    // Atributo adicional específico para treinadores
    private double taxaMensalAcademia; // Taxa mensal cobrada pelo treinador

    // Construtor que inicializa os atributos da classe, incluindo o atributo
    // específico para treinadores
    public Treinador(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha,
            double taxaMensalAcademia) {
        // Chamada ao construtor da classe base (Pessoa) para inicializar os atributos
        // comuns
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha);
        this.taxaMensalAcademia = taxaMensalAcademia;
    }

    // Métodos para acessar e modificar o atributo específico para treinadores
    public double getTaxaMensalAcademia() {
        return taxaMensalAcademia;
    }

    public void setTaxaMensalAcademia(double taxaMensalAcademia) {
        this.taxaMensalAcademia = taxaMensalAcademia;
    }

    // Sobrescrita do método toString para fornecer uma representação textual do
    // treinador
    @Override
    public String toString() {
        return "Treinador: " + getNome() + " (Taxa Mensal: " + taxaMensalAcademia + ")";
    }
}
