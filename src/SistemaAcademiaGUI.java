
// Importa a classe Swing necessária para criar a interface gráfica
import javax.swing.*;

// Classe principal que representa a interface gráfica do sistema da academia
public class SistemaAcademiaGUI {
    // Constantes para login padrão do funcionário
    private static final String LOGIN_FUNCIONARIO_PADRAO = "Admin";
    private static final String SENHA_FUNCIONARIO_PADRAO = "Admin";

    // Variáveis de controle de login
    private static boolean funcionarioLogado = false;
    private static Cliente clienteLogado = null;

    // Método principal que inicia o programa
    public static void main(String[] args) {
        // Instância da classe que representa a academia
        Academia academia = new Academia();

        // Loop de login do funcionário
        while (!funcionarioLogado) {
            realizarLogin(academia);

        }

        // Exibe o menu principal após o login
        exibirMenu(academia);

    }

    // Métodos para exibir diferentes menus e processar escolhas
    private static void exibirMenu(Academia academia) {
        while (true) {
            String[] opcoes = {
                    "Cadastrar Cliente", "Cadastrar Treinador", "Cadastrar Instrutor",
                    "Criar Ficha", "Visualizar Ficha", "Adicionar Exercício", "Listar Pessoas", "Voltar pro Login",
                    "Sair"
            };

            int escolha = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoes);

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
                visualizarTodasAsFichas(academia);
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

    private static void exibirMenuInstrutor(Academia academia) {
        while (true) {
            String[] opcoesInstrutor = {
                    "Criar Ficha", "Visualizar Ficha", "Adicionar Exercício", "Voltar pro Login",
                    "Sair"
            };

            int escolhaInstrutor = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoesInstrutor);

            try {
                if (escolhaInstrutor >= 0 && escolhaInstrutor < opcoesInstrutor.length) {
                    processarEscolhaInstrutor(academia, escolhaInstrutor);
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

    private static void processarEscolhaInstrutor(Academia academia, int escolhaInstrutor) {
        switch (escolhaInstrutor) {
            case 0:
                criarFicha(academia);
                break;
            case 1:
                visualizarTodasAsFichas(academia);
                break;
            case 2:
                adicionarExercicio(academia);
                break;
            case 3:
                realizarLogin(academia);
                break;
            case 4:
                exibirMensagem("Saindo do programa.");
                System.exit(0);
        }
    }

    private static void exibirMenuCliente(Academia academia) {
        while (true) {
            String[] opcoesCliente = {
                    "Visualizar Sua Ficha", "Realizar Pagamento", "Voltar pro Login", "Sair"
            };

            int escolhaCliente = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoesCliente);

            try {
                if (escolhaCliente >= 0 && escolhaCliente < opcoesCliente.length) {
                    processarEscolhaCliente(academia, escolhaCliente);
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

    private static void processarEscolhaCliente(Academia academia, int escolhaCliente) {
        switch (escolhaCliente) {
            case 0:
                visualizarFicha(academia, clienteLogado);
                break;
            case 1:
                realizarPagamento();
                break;
            case 2:
                realizarLogin(academia);
                break;
            case 3:
                exibirMensagem("Saindo do programa.");
                System.exit(0);
        }
    }

    private static void exibirMenuTreinador(Academia academia) {
        while (true) {
            String[] opcoesTreinador = {
                    "Criar Ficha", "Visualizar Ficha", "Adicionar Exercício", "Voltar pro Login",
                    "Sair"
            };

            int escolhaTreinador = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoesTreinador);

            try {
                if (escolhaTreinador >= 0 && escolhaTreinador < opcoesTreinador.length) {
                    processarEscolhaTreinador(academia, escolhaTreinador);
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

    private static void processarEscolhaTreinador(Academia academia, int escolhaTreinador) {
        switch (escolhaTreinador) {
            case 0:
                criarFicha(academia);
                break;
            case 1:
                visualizarFicha(academia, clienteLogado);
                break;
            case 2:
                adicionarExercicio(academia);
                break;
            case 3:
                realizarLogin(academia);
                break;
            case 4:
                exibirMensagem("Saindo do programa.");
                System.exit(0);
        }
    }

    private static void realizarLogin(Academia academia) {
        String[] opcoesLogin = { "Login Funcionário", "Login Cliente", "Login Treinador", "Login Instrutor", "Sair" };
        int escolhaLogin = exibirOpcoes("Escolha uma opção de login:", "Energy Academia", opcoesLogin);

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

    // Método para realizar o login do funcionário
    private static void realizarLoginFuncionario(Academia academia) {
        // Loop para solicitar login e senha até que o login seja bem-sucedido
        while (true) {
            String login = JOptionPane.showInputDialog("Digite o login do funcionário:");
            String senha = JOptionPane.showInputDialog("Digite a senha do funcionário:");

            // Verifica se o login e a senha correspondem ao padrão
            if (LOGIN_FUNCIONARIO_PADRAO.equals(login) && SENHA_FUNCIONARIO_PADRAO.equals(senha)) {
                exibirMensagem("Login de funcionário bem-sucedido.");
                funcionarioLogado = true;
                exibirMenu(academia);
                return;
            } else {
                // Se o login falhar, dá a opção de tentar novamente ou sair
                int opcao = JOptionPane.showConfirmDialog(null,
                        "Login de funcionário falhou. Tente novamente.",
                        "Erro de Login", JOptionPane.YES_NO_OPTION);

                if (opcao == JOptionPane.NO_OPTION) {
                    realizarLogin(academia);
                }
            }
        }
    }

    // Métodos para realizar o login de cliente, treinador e instrutor
    private static void realizarLoginCliente(Academia academia) {
        while (true) {
            String login = JOptionPane.showInputDialog("Digite o login do cliente:");

            if (login == null) {
                exibirMensagem("Operação de login cancelada.");
                realizarLogin(academia);
                return;
            }

            String senha = JOptionPane.showInputDialog("Digite a senha do cliente:");

            for (Pessoa pessoa : academia.getPessoas()) {
                if (pessoa instanceof Cliente && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    exibirMensagem("Login de cliente bem-sucedido.");
                    clienteLogado = (Cliente) pessoa;
                    funcionarioLogado = true;
                    exibirMenuCliente(academia);
                    return;
                }
            }

            exibirMensagem("Login de cliente falhou. Tente novamente.");
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
                    exibirMenuTreinador(academia);
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
                    exibirMenuInstrutor(academia);
                    return;
                }
            }

            // Mensagem de erro se o login falhar
            exibirMensagem("Login de instrutor falhou. Tente novamente.");
            realizarLogin(academia);
        }
    }

    // Métodos para cadastrar cliente, treinador e instrutor
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

            Cliente cliente = new Cliente(nome, dataNascimento, endereco, cep, email, telefone,
                    login, senha);
            academia.adicionarPessoa(cliente);
            exibirMensagem("Cliente adicionado com sucesso. ID: " + cliente.getId());
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

            Treinador treinador = new Treinador(nome, dataNascimento, endereco, cep, email, telefone,
                    login, senha, taxaMensalAcademia);
            academia.adicionarPessoa(treinador);
            exibirMensagem("Treinador adicionado com sucesso. ID: " + treinador.getId());
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

    // Métodos para criar, visualizar e adicionar exercícios em fichas
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
                // Procura a ficha existente para o cliente
                FichaAcademia fichaExistente = null;
                for (FichaAcademia ficha : academia.getFichas()) {
                    if (ficha.getNomeCliente().equals(nomeClienteSelecionado)) {
                        fichaExistente = ficha;
                        break;
                    }
                }

                // Se existe uma ficha, pergunta ao usuário se deseja substituir
                if (fichaExistente != null) {
                    int opcaoSubstituir = JOptionPane.showConfirmDialog(null,
                            "Já existe uma ficha para este cliente. Deseja substituir?",
                            "Substituir Ficha", JOptionPane.YES_NO_OPTION);

                    if (opcaoSubstituir == JOptionPane.YES_OPTION) {
                        // Remove a ficha existente antes de criar a nova
                        academia.removerFicha(fichaExistente);
                    } else {
                        // Se o usuário não quiser substituir, encerra o método
                        return;
                    }
                }

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

    private static void visualizarTodasAsFichas(Academia academia) {
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

    private static void visualizarFicha(Academia academia, Cliente clienteLogado) {
        if (academia.getFichas().isEmpty()) {
            exibirMensagemErro("Não há fichas de academia criadas no sistema.");
        } else {
            String[] nomesClientes = new String[academia.getFichas().size()];
            for (int i = 0; i < academia.getFichas().size(); i++) {
                nomesClientes[i] = academia.getFichas().get(i).getNomeCliente();
            }

            if (clienteLogado != null) {
                String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                        "Selecione um cliente para visualizar a ficha:",
                        "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null, nomesClientes,
                        nomesClientes[0]);

                if (nomeClienteSelecionado != null) {
                    // Verifica se a ficha pertence ao cliente logado
                    if (!nomeClienteSelecionado.equals(clienteLogado.getNome())) {
                        exibirMensagemErro("Você não tem permissão para visualizar a ficha de outro cliente.");
                        return;
                    }

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
                            return;
                        }
                    }
                }
            } else {
                // Caso não haja cliente logado, encerra a visualização
                exibirMensagemErro("Nenhum cliente logado. Realize o login como cliente para acessar sua ficha.");
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

    // Método para listar todas as pessoas cadastradas na academia
    private static void listarPessoas(Academia academia) {
        if (academia.getPessoas().isEmpty()) {
            exibirMensagemErro("Não há usuários cadastrados no sistema.");
        } else {
            // Constrói uma mensagem com as pessoas cadastradas, incluindo IDs
            StringBuilder pessoasCadastradas = new StringBuilder("Pessoas cadastradas na academia:\n");
            for (Pessoa pessoa : academia.getPessoas()) {
                pessoasCadastradas.append(pessoa).append("\n");
            }
            // Exibe a mensagem com as pessoas cadastradas
            exibirMensagem(pessoasCadastradas.toString());
        }
    }

    private static void realizarPagamento() {
        try {
            // Carrega a imagem do QR Code a partir de um arquivo
            ImageIcon qrcodeIcon = new ImageIcon("imagens/qrcode.png");

            // Exibe a imagem no JOptionPane
            JOptionPane.showMessageDialog(null, qrcodeIcon, "Pagamento", JOptionPane.PLAIN_MESSAGE);

            exibirMensagem("Pagamento realizado com sucesso!");
        } catch (Exception e) {
            exibirMensagemErro("Ocorreu um erro ao exibir o QR Code de pagamento: " + e.getMessage());
        }
    }

    // Método para exibir opções em uma caixa de diálogo
    private static int exibirOpcoes(String mensagem, String titulo, String[] opcoes) {
        return JOptionPane.showOptionDialog(
                null,
                mensagem,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("imagens/halter pixel art.png"),
                opcoes,
                opcoes[0]);
    }

    // Métodos auxiliares para exibir mensagens
    private static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

}