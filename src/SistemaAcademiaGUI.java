
// Importa as bibliotecas, list, stream e swing.
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

// Classe principal que representa o sistema da academia e sua interface grafica
public class SistemaAcademiaGUI {
    // Constantes para login padrão do funcionário
    private static final String LOGIN_FUNCIONARIO_PADRAO = "Admin";
    private static final String SENHA_FUNCIONARIO_PADRAO = "Admin";

    // Variáveis de controle
    private static boolean Logado = false;
    private static Cliente clienteLogado = null;

    // Método principal que inicia o programa
    public static void main(String[] args) {
        // Instância da classe que representa a academia
        Academia academia = new Academia();

        // Loop de login
        while (!Logado) {
            realizarLogin(academia);

        }

        // Exibe o menu principal após o login
        exibirMenu(academia);

    }

    // Métodos para exibir o menu do Funcionario (Admin, Admin)
    private static void exibirMenu(Academia academia) {
        while (true) {
            String[] opcoes = { // Array de strings para armazenar as opcoes do Funcionario
                    "Cadastrar Cliente", "Cadastrar Instrutor",
                    "Listar Pessoas", "Voltar pro Login",
                    "Sair"
            };

            // Exibe as opções e obtém a escolha do usuário atraves de um ShowOptionDialog
            // do JOPTIONPANE.
            int escolha = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoes);

            try { // Tratamento de excecao.

                // Processa a escolha do usuário
                // Se a escolha estiver entre 0 ou o tamanho da Array de Strings
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

    // Metodo para processar a escolha da pessoa Funcionario
    private static void processarEscolha(Academia academia, int escolha) {
        switch (escolha) { // Estrutura switch para processar a escolha atraves do numero digitado
            case 0: // No nosso caso o numero digitado esta sendo substituido por botoes do Swing.
                cadastrarCliente(academia); // Chama o metodo cadastrarCliente
                break;
            case 1:
                cadastrarInstrutor(academia); // Chama o metodo cadastrarInstrutor
                break;
            case 2:
                listarPessoas(academia); // Chama o metodo listarPessoas
                break;
            case 3:
                realizarLogin(academia); // Chama o metodo realizarLogin
                break;
            case 4:
                exibirMensagem("Saindo do programa."); // Encerra o programa (Sair)
                System.exit(0);
        }
    }

    // Metodo para exibir o menu da pessoa instrutor
    private static void exibirMenuInstrutor(Academia academia) {
        while (true) {
            String[] opcoesInstrutor = { // Array de strings para armazenar as opcoes do menu do instrutor
                    "Criar Ficha", "Visualizar Ficha", "Adicionar Exercício", "Voltar pro Login",
                    "Sair"
            };

            // Exibe as opções e obtém a escolha do Instrutor atraves de um ShowOptionDialog
            // do JOPTIONPANE. (exibirOpcoes)
            int escolhaInstrutor = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoesInstrutor);

            try {
                // Processa a escolha da Pessoa Instrutuor
                // Se a escolha estiver entre 0 ou o tamanho da Array de Strings
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

    // Metodo para processar a escolha da pessoa Instrutor
    private static void processarEscolhaInstrutor(Academia academia, int escolhaInstrutor) {
        switch (escolhaInstrutor) { // Estrutura switch para processar a escolha atraves do numero digitado
            case 0:
                criarFicha(academia); // Chama o metodo criar ficha
                break;
            case 1:
                visualizarTodasAsFichas(academia); // Chama o metodo visualizarTodasAsFichas
                break; // (Particularidade do Instrutor.)
            case 2:
                adicionarExercicio(academia); // Chama o metodo adicionarExercicio
                break; // (Particularidade do Instrutor)
            case 3:
                realizarLogin(academia); // Chama o metodo realizarLogin
                break;
            case 4:
                exibirMensagem("Saindo do programa."); // Encerra a execucao
                System.exit(0);
        }
    }

    // Metodo para exibir o menu da pessoa Cliente
    private static void exibirMenuCliente(Academia academia) {
        while (true) {
            String[] opcoesCliente = { // Array de strings para armazenar as opcoes do cliente.
                    "Visualizar Sua Ficha", "Realizar Pagamento", "Voltar pro Login", "Sair"
            };
            // Exibe as opções e obtém a escolha do Cliente atraves de um ShowOptionDialog
            // do JOPTIONPANE. (exibirOpcoes)
            int escolhaCliente = exibirOpcoes("Escolha uma opção:", "Energy Academia", opcoesCliente);

            try {
                // Processa a escolha da Pessoa Instrutuor
                // Se a escolha estiver entre 0 ou o tamanho da Array de Strings
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

    // Metodo para processar a escolha do Cliente
    private static void processarEscolhaCliente(Academia academia, int escolhaCliente) {
        switch (escolhaCliente) { // Estrutura switch para processar a escolha atraves do numero digitado
            case 0:
                visualizarFicha(academia, clienteLogado); // Chama o metodo para o cliente logado no momento
                break; // visualizar apenas a sua ficha
            case 1:
                realizarPagamento(); // Chama o metodo para realizarPagamento (Simulacao).
                break;
            case 2:
                realizarLogin(academia); // Chama o metodo realizarLogin.
                break;
            case 3:
                exibirMensagem("Saindo do programa."); // Encerra o programa.
                System.exit(0);
        }
    }

    // Metodo que exibe o menu com os tipos de login para cada Pessoa
    private static void realizarLogin(Academia academia) {
        // Array de Strings que armazena as opcoes de Login.
        String[] opcoesLogin = { "Login Funcionário", "Login Cliente", "Login Instrutor", "Sair" };

        // Exibe as opções e obtém a escolha pertinente a Pessoa do momento atraves de
        // um ShowOptionDialog
        // do JOPTIONPANE. (exibirOpcoes)
        int escolhaLogin = exibirOpcoes("Escolha uma opção de login:", "Energy Academia", opcoesLogin);

        switch (escolhaLogin) { // Estrutura switch
            case 0:
                realizarLoginFuncionario(academia); // chama o metodo de login do funcionario
                break;
            case 1:
                realizarLoginCliente(academia); // chama o metodo de login do cliente
                break;
            case 2:
                realizarLoginInstrutor(academia); // chama o metodo de login do instrutor
                break;
            case 3:
                exibirMensagem("Saindo do programa."); // encerra o programa.
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
                Logado = true;
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

    // Método para realizar o login da pessoa Cliente
    private static void realizarLoginCliente(Academia academia) {
        // Loop de login do cliente
        while (true) {
            // Solicita o login do cliente por meio de uma caixa de diálogo
            String login = JOptionPane.showInputDialog("Digite o login do cliente:");

            // Verifica se o cliente cancelou a operação
            if (login == null) {
                exibirMensagem("Operação de login cancelada.");
                // Retorna à tela de opção de login após o login mal sucedido
                realizarLogin(academia); // Volta pra tela de login
                return;
            }

            // Solicita a senha do cliente por meio de uma caixa de diálogo
            String senha = JOptionPane.showInputDialog("Digite a senha do cliente:");

            // Percorrendo todas as pessoas associadas à academia,
            // e em cada iteração do loop, a variável pessoa representa uma pessoa
            // específica na coleção.
            // para encontrar o cliente correspondente ao login e senha
            for (Pessoa pessoa : academia.getPessoas()) {
                // Verifica se a pessoa é do tipo Cliente e se as credenciais são corretas
                if (pessoa instanceof Cliente && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    exibirMensagem("Login de cliente bem-sucedido."); // Exibe a mensagem de sucesso
                    // Define o cliente logado
                    clienteLogado = (Cliente) pessoa;
                    // Exibe o menu do cliente
                    exibirMenuCliente(academia);
                    return;
                }
            }
            // Falha no login
            exibirMensagem("Login de cliente falhou. Tente novamente.");
        }
    }

    // Metodo para realizar o login da pessoa Instrutor
    private static void realizarLoginInstrutor(Academia academia) {
        // Loop de login do cliente
        while (true) {
            // Solicita o login do cliente por meio de uma caixa de diálogo
            String login = JOptionPane.showInputDialog("Digite o login do instrutor:");

            // Verifica se o instrutor cancelou a operação
            if (login == null) {
                exibirMensagem("Operação de login cancelada.");
                // Retorna à tela de opção de login após o login mal sucedido
                realizarLogin(academia);
                return;
            }

            String senha = JOptionPane.showInputDialog("Digite a senha do instrutor:");

            // Percorre todas as pessoas associadas à academia,
            // e em cada iteração do loop, a variável pessoa representa uma pessoa
            // específica na coleção <lista>.
            // para encontrar o cliente correspondente ao login e senha
            for (Pessoa pessoa : academia.getPessoas()) {
                // Verifica se a pessoa é do tipo Instrutor e se as credenciais são corretas
                if (pessoa instanceof Instrutor && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                    exibirMensagem("Login de instrutor bem-sucedido.");

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

    // Métodos para cadastrar cliente
    private static void cadastrarCliente(Academia academia) {
        // Solicita o nome do cliente
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        if (nome != null && !nome.isEmpty()) { // Verifica se o nome nao esta vazio
            // Prossegue com o resto do cadastro
            String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do cliente:");
            String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
            String cep = JOptionPane.showInputDialog("Digite o CEP do cliente:");
            String email = JOptionPane.showInputDialog("Digite o email do cliente:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
            String login = JOptionPane.showInputDialog("Digite o login do cliente:");
            String senha = JOptionPane.showInputDialog("Digite a senha do cliente:");

            // Cria um objeto cliente com as informacoes fornecidas
            Cliente cliente = new Cliente(nome, dataNascimento, endereco, cep, email, telefone,
                    login, senha);
            // Adiciona esse cliente a lista de pessoas da academia
            academia.adicionarPessoa(cliente);
            exibirMensagem("Cliente adicionado com sucesso. ID: " + cliente.getId());
        } else {
            exibirMensagemErro("Nome do cliente inválido.");
        }
    }

    // Metodo para realizar o cadastro do Instrutor
    private static void cadastrarInstrutor(Academia academia) {
        // Solicita o nome do cliente
        String nome = JOptionPane.showInputDialog("Digite o nome do instrutor:");
        if (nome != null && !nome.isEmpty()) { // Verifica se o nome nao esta vazio
            // Prossegue com o resto do cadastro
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

            // Cria o objeto instrutor com as informacoes fornecidas
            Instrutor instrutor = new Instrutor(nome, dataNascimento, endereco, cep, email, telefone, login,
                    senha, dataAdmissao, dataDemissao, remuneracao, dataRemuneracao, expediente,
                    atendimentoDiasSemana, atendimentoPeriodo);
            // Adiciona esse Istrutor cadastrado a lista de pessoas da academia
            academia.adicionarPessoa(instrutor);
            exibirMensagem("Instrutor adicionado com sucesso.");
        } else {
            exibirMensagemErro("Nome do instrutor inválido.");
        }
    }

    // Métodos para criar uma ficha para um cliente
    private static void criarFicha(Academia academia) {
        // Verifica se nao ha usuarios cadastrados no sistema
        if (academia.getPessoas().isEmpty()) {
            exibirMensagemErro("Não há usuários cadastrados no sistema.");
        } else {
            // Filtra apenas os clientes da lista de pessoas e obtem seus nomes e atribue a
            // lista nomesClientes
            List<String> nomesClientes = academia.getPessoas().stream()
                    .filter(pessoa -> pessoa instanceof Cliente)
                    .map(Pessoa::getNome)
                    .collect(Collectors.toList());
            // Verifica se nao ha clientes cadastrados
            if (nomesClientes.isEmpty()) {
                exibirMensagemErro("Não há clientes cadastrados no sistema.");
                return;
            }

            // Solicita ao instrutor que selecione um cliente para criar a ficha e atribue
            // ao nomeClienteSelecionado
            String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um cliente:",
                    "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null,
                    nomesClientes.toArray(new String[0]),
                    nomesClientes.get(0));

            // Verifica a condicao se o usuario selecionou um cliente
            if (nomeClienteSelecionado != null) {
                // Procura a ficha existente para o cliente selecionado
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

                    // Caso o instrutor queria substituir a ficha do cliente
                    if (opcaoSubstituir == JOptionPane.YES_OPTION) {
                        // Remove a ficha existente antes de criar a nova
                        academia.removerFicha(fichaExistente);
                    } else {
                        // Se o usuário não quiser substituir, encerra o método
                        return;
                    }
                }

                // Cria uma nova ficha para o nomeclienteSelecionado
                FichaAcademia ficha = new FichaAcademia(nomeClienteSelecionado);
                boolean criandoFicha = true;

                // Loop para adicionar exercicios a ficha
                while (criandoFicha) {
                    try {
                        // Solicita o nome do exercicio
                        String exercicio = JOptionPane.showInputDialog("Digite o nome do exercício:");
                        // Verifica se o nome do exercicio foi fornecido e nao esta vazio
                        if (exercicio != null && !exercicio.isEmpty()) {
                            // Solicita a quantidade de series do exercicio
                            int serie = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de séries:"));
                            // Solicita a quantidade de repeticao do exercicio
                            int repeticao = Integer
                                    .parseInt(JOptionPane.showInputDialog("Digite o número de repetições:"));
                            // Adiciona os exercicios, series e repeticoes a ficha do cliente
                            ficha.adicionarExercicio(exercicio, serie, repeticao);

                            // Pergunta se o instrutor ainda quer adicionar exercicios, caso queira:
                            int opcao = JOptionPane.showConfirmDialog(null,
                                    "Deseja adicionar outro exercício?",
                                    "Continuar", JOptionPane.YES_NO_OPTION);
                            // se nao, finaliza o processo
                            if (opcao == JOptionPane.NO_OPTION) {
                                academia.criarFicha(ficha);
                                criandoFicha = false;
                            }
                        } else { // Exibe mensagem de erro caso o nome do exercicio nao seja valido
                            exibirMensagemErro("Nome do exercício inválido.");
                        }
                    } catch (NumberFormatException e) {
                        exibirMensagemErro("Erro: Insira um número válido para séries e repetições.");
                    } catch (Exception e) {
                        exibirMensagemErro("Ocorreu um erro inesperado: " + e.getMessage());
                    }
                }

                exibirMensagem("Ficha de academia criada com sucesso."); // Mensagem de sucesso
            }
        }
    }

    // Método para visualizar todas as fichas de academia criadas no sistema
    private static void visualizarTodasAsFichas(Academia academia) {
        // Verifica se não há fichas de academia criadas no sistema
        if (academia.getFichas().isEmpty()) {
            exibirMensagemErro("Não há fichas de academia criadas no sistema.");
        } else {
            // Cria um array de strings para armazenar os nomes dos clientes associados a
            // ficha
            String[] nomesClientes = new String[academia.getFichas().size()];
            // Percorre sobre a lista de fichas da academia
            for (int i = 0; i < academia.getFichas().size(); i++) {
                // Para cada ficha, obtem o nome do cliente
                nomesClientes[i] = academia.getFichas().get(i).getNomeCliente();
            }

            // Solicita ao instrutor que selecione um cliente para visualizar a ficha
            String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um cliente para visualizar a ficha:",
                    "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null, nomesClientes,
                    nomesClientes[0]);

            // Verifica se o usuário selecionou um cliente
            if (nomeClienteSelecionado != null) {
                // Percorre sobre as fichas procurando pela correspondente ao cliente
                // selecionado
                for (FichaAcademia ficha : academia.getFichas()) {
                    if (ficha.getNomeCliente().equals(nomeClienteSelecionado)) {
                        // Constrói uma representação de texto da ficha
                        StringBuilder fichaTexto = new StringBuilder(
                                "Ficha de " + nomeClienteSelecionado + ":\n");

                        // Itera sobre os exercícios da ficha e os adiciona à representação de texto
                        for (int i = 0; i < ficha.getExercicios().size(); i++) {
                            fichaTexto.append("Exercício: ").append(ficha.getExercicios().get(i))
                                    .append(", Séries: ").append(ficha.getSeries().get(i))
                                    .append(", Repetições: ").append(ficha.getRepeticoes().get(i))
                                    .append("\n");
                        }

                        // Exibe a ficha de academia ao usuário
                        exibirMensagem(fichaTexto.toString());
                        break;
                    }
                }
            }
        }
    }

    // Metodo para o cliente conseguir visualizar apenas a sua propria ficha.
    private static void visualizarFicha(Academia academia, Cliente clienteLogado) {
        if (academia.getFichas().isEmpty()) { // Verifica se ha fichas na lista
            exibirMensagemErro("Não há fichas de academia criadas no sistema.");
        } else {
            // Cria um array de strings para armazenar os nomes dos clientes associados a
            // ficha
            String[] nomesClientes = new String[academia.getFichas().size()];
            // Percorre sobre a lista de fichas da academia
            for (int i = 0; i < academia.getFichas().size(); i++) {
                // Para cada ficha, obtem o nome do cliente
                nomesClientes[i] = academia.getFichas().get(i).getNomeCliente();
            }

            // Verifica se há um cliente logado
            if (clienteLogado != null) {
                // Solicita ao usuário que selecione um cliente para visualizar a ficha
                String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                        "Selecione um cliente para visualizar a ficha:",
                        "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null, nomesClientes,
                        nomesClientes[0]);

                // Verifica se o usuário selecionou um cliente
                if (nomeClienteSelecionado != null) {
                    // Verifica se a ficha pertence ao cliente logado
                    if (!nomeClienteSelecionado.equals(clienteLogado.getNome())) {
                        exibirMensagemErro("Você não tem permissão para visualizar a ficha de outro cliente.");
                        return;
                    }

                    // Percorre sobre as fichas procurando pela correspondente ao cliente
                    // selecionado
                    for (FichaAcademia ficha : academia.getFichas()) {
                        if (ficha.getNomeCliente().equals(nomeClienteSelecionado)) {
                            // Constrói uma representação de texto da ficha
                            StringBuilder fichaTexto = new StringBuilder(
                                    "Ficha de " + nomeClienteSelecionado + ":\n");

                            // Itera sobre os exercícios da ficha e os adiciona à representação de texto
                            for (int i = 0; i < ficha.getExercicios().size(); i++) {
                                fichaTexto.append("Exercício: ").append(ficha.getExercicios().get(i))
                                        .append(", Séries: ").append(ficha.getSeries().get(i))
                                        .append(", Repetições: ").append(ficha.getRepeticoes().get(i))
                                        .append("\n");
                            }
                            // Exibe a ficha de academia ao usuário
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

    // Metodo para adicionar exercicio a uma ficha existente
    private static void adicionarExercicio(Academia academia) {
        // Verifica se não há usuários cadastrados no sistema
        if (academia.getPessoas().isEmpty()) {
            exibirMensagemErro("Não há usuários cadastrados no sistema.");
        } else {
            // Filtra apenas os clientes da lista de pessoas
            List<String> nomesClientes = academia.getPessoas().stream()
                    .filter(pessoa -> pessoa instanceof Cliente)
                    .map(Pessoa::getNome)
                    .collect(Collectors.toList());

            // Verifica se nao ha clientes cadastrados no sistema
            if (nomesClientes.isEmpty()) {
                exibirMensagemErro("Não há clientes cadastrados no sistema.");
                return;
            }

            // Solicita que o Instrutor selecione um cliente
            String nomeClienteSelecionado = (String) JOptionPane.showInputDialog(null,
                    "Selecione um cliente:",
                    "Selecionar Cliente", JOptionPane.QUESTION_MESSAGE, null,
                    nomesClientes.toArray(new String[0]),
                    nomesClientes.get(0));

            // Verifica se ha cliente selecionado, ou seja nao e nulo
            if (nomeClienteSelecionado != null) {
                // Procura a ficha existente para o cliente
                FichaAcademia fichaExistente = null;
                for (FichaAcademia ficha : academia.getFichas()) {
                    if (ficha.getNomeCliente().equals(nomeClienteSelecionado)) {
                        fichaExistente = ficha;
                        break;
                    }
                }

                // Se não houver uma ficha para o cliente, exibe mensagem de erro
                if (fichaExistente == null) {
                    exibirMensagemErro("Não foi encontrada uma ficha para o cliente selecionado.");
                    return;
                }

                try {
                    // Solicita informações sobre o novo exercício
                    String exercicio = JOptionPane.showInputDialog("Digite o nome do exercício:");
                    if (exercicio != null && !exercicio.isEmpty()) {
                        int serie = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de séries:"));
                        int repeticao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de repetições:"));

                        // Adiciona o exercício à ficha existente para o cliente
                        fichaExistente.adicionarExercicio(exercicio, serie, repeticao);

                        exibirMensagem("Exercício adicionado com sucesso.");
                    } else {
                        exibirMensagemErro("Nome do exercício inválido.");
                    }
                } catch (NumberFormatException e) {
                    exibirMensagemErro("Erro: Insira um número válido para séries e repetições.");
                } catch (Exception e) {
                    exibirMensagemErro("Ocorreu um erro inesperado: " + e.getMessage());
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
            // Percorre sobre a lista de pessoas
            for (Pessoa pessoa : academia.getPessoas()) {
                // Adiciona informacoes da pessoa a mensagem
                pessoasCadastradas.append(pessoa).append("\n");
            }
            // Exibe a mensagem com as pessoas cadastradas
            exibirMensagem(pessoasCadastradas.toString());
        }
    }

    // Metodo pra simular a realizacao de um pagamento
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

    // Método auxiliar para exibir mensagens
    private static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    // Método auxiliar para exibir mensagens de erro
    private static void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

}