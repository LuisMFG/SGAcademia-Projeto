import javax.swing.*;

public class SistemaAcademiaGUI {
    private static final String LOGIN_FUNCIONARIO_PADRAO = "Admin";
    private static final String SENHA_FUNCIONARIO_PADRAO = "Admin";

    private static boolean funcionarioLogado = false;

    public static void main(String[] args) {
        Academia academia = new Academia();

        while (!funcionarioLogado) {
            realizarLogin(academia);
        }

        exibirMenu(academia);
    }

    private static void exibirMenu(Academia academia) {
        while (true) {
            String[] opcoes = {
                    "Cadastrar Cliente", "Cadastrar Treinador", "Cadastrar Instrutor",
                    "Criar Ficha", "Visualizar Ficha", "Adicionar Exercício", "Listar Pessoas", "Voltar pro Login",
                    "Sair"
            };

            int escolha = exibirOpcoes("Escolha uma opção:", "Sistema de Academia", opcoes);

            try {
                if (escolha >= 0 && escolha < opcoes.length) {
                    processarEscolha(academia, escolha);
                } else {
                    exibirMensagemErro("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                exibirMensagemErro("Erro: Insira um número válido.");
            } catch (Exception e) {
                exibirMensagemErro("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void processarEscolha(Academia academia, int escolha) {
        switch (escolha) {
            case 0:
                cadastrarCliente(academia);
                break;
            case 1:
                cadastrarTreinador(academia);
                break;
            case 2:
                cadastrarInstrutor(academia);
                break;
            case 3:
                criarFicha(academia);
                break;
            case 4:
                visualizarFicha(academia);
                break;
            case 5:
                adicionarExercicio(academia);
                break;
            case 6:
                listarPessoas(academia);
                break;
            case 7:
                realizarLogin(academia);
                break;
            case 8:
                exibirMensagem("Saindo do programa.");
                System.exit(0);
        }
    }

    private static void realizarLogin(Academia academia) {
        String[] opcoesLogin = { "Login Funcionário", "Login Cliente", "Login Treinador", "Login Instrutor", "Sair" };
        int escolhaLogin = exibirOpcoes("Escolha uma opção de login:", "Login", opcoesLogin);

        switch (escolhaLogin) {
            case 0:
                realizarLoginFuncionario(academia);
                break;
            case 1:
                realizarLoginCliente(academia);
                break;
            case 2:
                realizarLoginTreinador(academia);
                break;
            case 3:
                realizarLoginInstrutor(academia);
                break;
            case 4:
                exibirMensagem("Saindo do programa.");
                System.exit(0);
        }
    }

    private static void realizarLoginFuncionario(Academia academia) {
        while (true) {
            String login = JOptionPane.showInputDialog("Digite o login do funcionário:");
            String senha = JOptionPane.showInputDialog("Digite a senha do funcionário:");

            if (LOGIN_FUNCIONARIO_PADRAO.equals(login) && SENHA_FUNCIONARIO_PADRAO.equals(senha)) {
                exibirMensagem("Login de funcionário bem-sucedido.");
                funcionarioLogado = true;
                return;
            } else {
                int opcao = JOptionPane.showConfirmDialog(null,
                        "Login de funcionário falhou. Tente novamente.",
                        "Erro de Login", JOptionPane.YES_NO_OPTION);

                if (opcao == JOptionPane.NO_OPTION) {
                    realizarLogin(academia);
                }
            }
        }
    }

    private static void realizarLoginCliente(Academia academia) {
        while (true) {
            String login = JOptionPane.showInputDialog("Digite o login do cliente:");

            // Tratamento para Cancelar ou fechar a janela
            if (login == null) {
                exibirMensagem("Operação de login cancelada.");
                realizarLogin(academia);

                return;
            }

            String senha = JOptionPane.showInputDialog("Digite a senha do cliente:");

            // Busca eficiente no conjunto de pessoas
            for (Pessoa pessoa : academia.getPessoas()) {
                if (pessoa instanceof Cliente && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    exibirMensagem("Login de cliente bem-sucedido.");
                    funcionarioLogado = true;

                    // Retorna à tela de opção de login após o login bem-sucedido
                    exibirMenu(academia);
                    return;
                }
            }

            // Mensagem de erro se o login falhar
            exibirMensagem("Login de cliente falhou. Tente novamente.");
            realizarLogin(academia);
        }
    }

    private static void realizarLoginTreinador(Academia academia) {
        while (true) {
            String login = JOptionPane.showInputDialog("Digite o login do treinador:");

            // Tratamento para Cancelar ou fechar a janela
            if (login == null) {
                exibirMensagem("Operação de login cancelada.");
                // Retorna à tela de opção de login
                realizarLogin(academia);
                return;
            }

            String senha = JOptionPane.showInputDialog("Digite a senha do treinador:");

            // Busca eficiente no conjunto de pessoas
            for (Pessoa pessoa : academia.getPessoas()) {
                if (pessoa instanceof Treinador && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    exibirMensagem("Login de treinador bem-sucedido.");
                    funcionarioLogado = true;

                    // Retorna à tela de opção de login após o login bem-sucedido
                    exibirMenu(academia);
                    return;
                }
            }

            // Mensagem de erro se o login falhar
            exibirMensagem("Login de treinador falhou. Tente novamente.");
        }
    }

    private static void realizarLoginInstrutor(Academia academia) {
        while (true) {
            String login = JOptionPane.showInputDialog("Digite o login do instrutor:");

            // Tratamento para Cancelar ou fechar a janela
            if (login == null) {
                exibirMensagem("Operação de login cancelada.");
                // Retorna à tela de opção de login
                realizarLogin(academia);
                return;
            }

            String senha = JOptionPane.showInputDialog("Digite a senha do instrutor:");

            // Busca eficiente no conjunto de pessoas
            for (Pessoa pessoa : academia.getPessoas()) {
                if (pessoa instanceof Instrutor && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    exibirMensagem("Login de instrutor bem-sucedido.");
                    funcionarioLogado = true;

                    // Retorna à tela de opção de login após o login bem-sucedido
                    exibirMenu(academia);
                    return;
                }
            }

            // Mensagem de erro se o login falhar
            exibirMensagem("Login de instrutor falhou. Tente novamente.");
            realizarLogin(academia);
        }
    }

    private static void cadastrarCliente(Academia academia) {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        if (nome != null && !nome.isEmpty()) {
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do cliente:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
            String cep = JOptionPane.showInputDialog("Digite o CEP do cliente:");
            String email = JOptionPane.showInputDialog("Digite o email do cliente:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
            String login = JOptionPane.showInputDialog("Digite o login do cliente:");
            String senha = JOptionPane.showInputDialog("Digite a senha do cliente:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cliente:"));

            Cliente cliente = new Cliente(nome, dataNascimento, endereco, cep, email, telefone, login,
                    senha, idade, senha, senha, senha);
            academia.adicionarPessoa(cliente);
            exibirMensagem("Cliente adicionado com sucesso.");
        } else {
            exibirMensagemErro("Nome do cliente inválido.");
        }
    }

    private static void cadastrarTreinador(Academia academia) {
        String nome = JOptionPane.showInputDialog("Digite o nome do treinador:");
        if (nome != null && !nome.isEmpty()) {
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do treinador:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço do treinador:");
            String cep = JOptionPane.showInputDialog("Digite o CEP do treinador:");
            String email = JOptionPane.showInputDialog("Digite o email do treinador:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do treinador:");
            String login = JOptionPane.showInputDialog("Digite o login do treinador:");
            String senha = JOptionPane.showInputDialog("Digite a senha do treinador:");
            double taxaMensalAcademia = Double
                    .parseDouble(JOptionPane.showInputDialog("Digite a taxa mensal do treinador:"));

            Treinador treinador = new Treinador(nome, dataNascimento, endereco, cep, email, telefone, login,
                    senha, taxaMensalAcademia);
            academia.adicionarPessoa(treinador);
            exibirMensagem("Treinador adicionado com sucesso.");
        } else {
            exibirMensagemErro("Nome do treinador inválido.");
        }
    }

    private static void cadastrarInstrutor(Academia academia) {
        String nome = JOptionPane.showInputDialog("Digite o nome do instrutor:");
        if (nome != null && !nome.isEmpty()) {
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do instrutor:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço do instrutor:");
            String cep = JOptionPane.showInputDialog("Digite o CEP do instrutor:");
            String email = JOptionPane.showInputDialog("Digite o email do instrutor:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do instrutor:");
            String login = JOptionPane.showInputDialog("Digite o login do instrutor:");
            String senha = JOptionPane.showInputDialog("Digite a senha do instrutor:");
            String dataAdmissao = JOptionPane.showInputDialog("Digite a data de admissão do instrutor:");
            String dataDemissao = JOptionPane.showInputDialog("Digite a data de demissão do instrutor:");
            double remuneracao = Double.parseDouble(JOptionPane.showInputDialog("Digite a remuneração do instrutor:"));
            String dataRemuneracao = JOptionPane.showInputDialog("Digite a data da remuneração do instrutor:");
            String expediente = JOptionPane.showInputDialog("Digite o expediente do instrutor:");
            String atendimentoDiasSemana = JOptionPane.showInputDialog("Digite os dias de atendimento do instrutor:");
            String atendimentoPeriodo = JOptionPane.showInputDialog("Digite o período de atendimento do instrutor:");

            Instrutor instrutor = new Instrutor(nome, dataNascimento, endereco, cep, email, telefone, login,
                    senha, dataAdmissao, dataDemissao, remuneracao, dataRemuneracao, expediente,
                    atendimentoDiasSemana, atendimentoPeriodo);

            academia.adicionarPessoa(instrutor);
            exibirMensagem("Instrutor adicionado com sucesso.");
        } else {
            exibirMensagemErro("Nome do instrutor inválido.");
        }
    }

    private static void criarFicha(Academia academia) {
        if (academia.getPessoas().isEmpty()) {
            exibirMensagemErro("Não há usuários cadastrados no sistema.");
        } else {
            String[] nomesClientes = new String[academia.getPessoas().size()];
            for (int i = 0; i < academia.getPessoas().size(); i++) {
                nomesClientes[i] = academia.getPessoas().get(i).getNome();
            }

            String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um cliente:",
                    "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null, nomesClientes,
                    nomesClientes[0]);

            if (nomeClienteSelecionado != null) {
                FichaAcademia ficha = new FichaAcademia(nomeClienteSelecionado);
                boolean criandoFicha = true;

                while (criandoFicha) {
                    try {
                        String exercicio = JOptionPane.showInputDialog("Digite o nome do exercício:");
                        if (exercicio != null && !exercicio.isEmpty()) {
                            int serie = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de séries:"));
                            int repeticao = Integer
                                    .parseInt(JOptionPane.showInputDialog("Digite o número de repetições:"));

                            ficha.adicionarExercicio(exercicio, serie, repeticao);

                            int opcao = JOptionPane.showConfirmDialog(null,
                                    "Deseja adicionar outro exercício?",
                                    "Continuar", JOptionPane.YES_NO_OPTION);
                            if (opcao == JOptionPane.NO_OPTION) {
                                academia.criarFicha(ficha);
                                criandoFicha = false;
                            }
                        } else {
                            exibirMensagemErro("Nome do exercício inválido.");
                        }
                    } catch (NumberFormatException e) {
                        exibirMensagemErro("Erro: Insira um número válido para séries e repetições.");
                    } catch (Exception e) {
                        exibirMensagemErro("Ocorreu um erro inesperado: " + e.getMessage());
                    }
                }

                exibirMensagem("Ficha de academia criada com sucesso.");
            }
        }
    }

    private static void visualizarFicha(Academia academia) {
        if (academia.getFichas().isEmpty()) {
            exibirMensagemErro("Não há fichas de academia criadas no sistema.");
        } else {
            String[] nomesClientes = new String[academia.getFichas().size()];
            for (int i = 0; i < academia.getFichas().size(); i++) {
                nomesClientes[i] = academia.getFichas().get(i).getNomeCliente();
            }

            String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um cliente para visualizar a ficha:",
                    "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null, nomesClientes,
                    nomesClientes[0]);

            if (nomeClienteSelecionado != null) {
                for (FichaAcademia ficha : academia.getFichas()) {
                    if (ficha.getNomeCliente().equals(nomeClienteSelecionado)) {
                        StringBuilder fichaTexto = new StringBuilder(
                                "Ficha de " + nomeClienteSelecionado + ":\n");

                        for (int i = 0; i < ficha.getExercicios().size(); i++) {
                            fichaTexto.append("Exercício: ").append(ficha.getExercicios().get(i))
                                    .append(", Séries: ").append(ficha.getSeries().get(i))
                                    .append(", Repetições: ").append(ficha.getRepeticoes().get(i))
                                    .append("\n");
                        }

                        exibirMensagem(fichaTexto.toString());
                        break;
                    }
                }
            }
        }
    }

    private static void adicionarExercicio(Academia academia) {
        if (academia.getPessoas().isEmpty()) {
            exibirMensagemErro("Não há usuários cadastrados no sistema.");
        } else {
            String[] nomesClientes = new String[academia.getPessoas().size()];
            for (int i = 0; i < academia.getPessoas().size(); i++) {
                nomesClientes[i] = academia.getPessoas().get(i).getNome();
            }

            String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um cliente:",
                    "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null, nomesClientes,
                    nomesClientes[0]);

            if (nomeClienteSelecionado != null) {
                for (FichaAcademia ficha : academia.getFichas()) {
                    if (ficha.getNomeCliente().equals(nomeClienteSelecionado)) {
                        try {
                            String exercicio = JOptionPane.showInputDialog("Digite o nome do exercício:");
                            if (exercicio != null && !exercicio.isEmpty()) {
                                int serie = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de séries:"));
                                int repeticao = Integer
                                        .parseInt(JOptionPane.showInputDialog("Digite o número de repetições:"));

                                ficha.adicionarExercicio(exercicio, serie, repeticao);
                                exibirMensagem("Exercício adicionado com sucesso.");
                            } else {
                                exibirMensagemErro("Nome do exercício inválido.");
                            }
                        } catch (NumberFormatException e) {
                            exibirMensagemErro("Erro: Insira um número válido para séries e repetições.");
                        } catch (Exception e) {
                            exibirMensagemErro("Ocorreu um erro inesperado: " + e.getMessage());
                        }
                        break;
                    }
                }
            }
        }
    }

    private static void listarPessoas(Academia academia) {
        if (academia.getPessoas().isEmpty()) {
            exibirMensagemErro("Não há usuários cadastrados no sistema.");
        } else {
            StringBuilder pessoasCadastradas = new StringBuilder("Pessoas cadastradas na academia:\n");
            for (Pessoa pessoa : academia.getPessoas()) {
                pessoasCadastradas.append(pessoa).append("\n");
            }
            exibirMensagem(pessoasCadastradas.toString());
        }
    }

    private static int exibirOpcoes(String mensagem, String titulo, String[] opcoes) {
        return JOptionPane.showOptionDialog(
                null,
                mensagem,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
    }

    private static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}