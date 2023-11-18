public class Cliente extends Pessoa {

    public Cliente(String nome, String dataNascimento, String endereco, String cep,
            String email, String telefone, String login, String senha) {
        super(nome, dataNascimento, endereco, cep, email, telefone, login, senha);
    }

    @Override
    public String toString() {
        return "Cliente - " + super.toString();
    }

}
