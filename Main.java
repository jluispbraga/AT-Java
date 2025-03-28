import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String response;

        System.out.println("Olá bem vindo ao meu AT de JAVA");
        while (true) {
            System.out.println("\nQual exercicio você quer executar?");
            System.out.println("""
                    1 - Instalando e configurando o ambiente Java
                    2 - Validação de Senha Segura
                    3 - Calculadora de Impostos
                    4 - Simulador de Empréstimo Bancário
                    5 - Criando um Programa CGI em Java
                    6 - Cadastro de Veículos
                    7 - Gerenciador de Alunos
                    8 - Sistema de Funcionários
                    9 - Conta Bancária com Encapsulamento
                    10 - Registro de Compras em Arquivo
                    11 - Simulação de Loteria
                    12 - Sistema de Chat Simples com Arrays""");
            response = scanner.nextLine();
            switch (response) {
                case "1":
                    ATX1();
                    break;
                case "2":
                    ATX2(scanner);
                    break;
                case "3":
                    ATX3(scanner);
                    break;
                case "4":
                    ATX4(scanner);
                    break;
                case "5":
                    ATX5();
                    break;
                case "6":
                    ATX6(scanner);
                    break;
                case "7":
                    ATX7(scanner);
                    break;
                case "8":
                    ATX8(scanner);
                    break;
                case "9":
                    ATX9(scanner);
                    break;
                case "10":
                    ATX10(scanner);
                    break;
                case "11":
                    ATX11(scanner, random);
                    break;
                case "12":
                    ATX12(scanner);
                    break;
                case "":
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção invalida, digite outro número ou aperte enter para sair");
            }
        }
    }

    public static void ATX1() {
        System.out.println("Olá meu nome é José Luís Pereira Braga e estou aprendendo Java!");
    }

    public static void ATX2(Scanner scanner) {
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        boolean min = senha.length() < 8;
        boolean regra = !senha.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");

        while (min || regra) {
            System.out.println("Senha inválida sua senha deve conter:");
            if (min) {
                System.out.println("Minino 8 caracteres");
            }
            if (regra) {
                System.out.println("Uma letra maiúscula, um número e um caractere especial (@, #, $, etc.)");
            }
            System.out.println("Digite sua senha ou aperte enter para sair:");
            senha = scanner.nextLine();

            if (Objects.equals(senha, "")) {
                System.out.println("Operação cancelada.");
                break;
            }

            min = senha.length() < 8;
            regra = !senha.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$");
        }

        if (!min && !regra) {
            System.out.println("Senha cadastrada com sucesso!");
        }
    }

    public static void ATX3(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu salário mensal: R$ ");
        double salarioMensal = scanner.nextDouble();

        double salarioAnual = salarioMensal * 12;

        double imposto = 0;
        if (salarioAnual > 45012.60) {
            imposto = salarioAnual * 0.275;
        } else if (salarioAnual > 33919.80) {
            imposto = salarioAnual * 0.15;
        } else if (salarioAnual > 22847.76) {
            imposto = salarioAnual * 0.075;
        }

        double salarioLiquido = salarioAnual - imposto;

        System.out.println("\nResumo:");
        System.out.println("Nome: " + nome);
        System.out.printf("Salário Anual: R$ %.2f%n", salarioAnual);
        System.out.printf("Imposto a pagar: R$ %.2f%n", imposto);
        System.out.printf("Salário Líquido: R$ %.2f%n", salarioLiquido);
    }

    public static void ATX4(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o valor do empréstimo: R$ ");
        double valorEmprestimo = scanner.nextDouble();

        int parcelas;
        do {
            System.out.print("Digite o número de parcelas (entre 6 e 48): ");
            parcelas = scanner.nextInt();
            if (parcelas < 6 || parcelas > 48) {
                System.out.println("Número de parcelas inválido. Informe um valor entre 6 e 48.");
            }
        } while (parcelas < 6 || parcelas > 48);

        double taxaJuros = 0.03;

        double valorTotalPago = valorEmprestimo * Math.pow(1 + taxaJuros, parcelas);
        double valorParcela = valorTotalPago / parcelas;

        System.out.println("\nSimulação de Empréstimo:");
        System.out.println("Cliente: " + nome);
        System.out.printf("Valor do Empréstimo: R$ %.2f%n", valorEmprestimo);
        System.out.printf("Total a Pagar: R$ %.2f%n", valorTotalPago);
        System.out.printf("Valor da Parcela: R$ %.2f%n", valorParcela);
    }

    public static void ATX5() {
        System.out.println("Content-Type: text/html");
        System.out.println();

        System.out.println("<html>");
        System.out.println("<head><title>Saudação CGI</title></head>");
        System.out.println("<body>");
        System.out.println("<h1>Olá, Terráqueos!</h1>");
        System.out.println("</body>");
        System.out.println("</html>");
    }

    public static class Veiculo {
        private final String placa;
        private final String modelo;
        private final int anoFabricacao;
        private double quilometragem;

        public Veiculo(String placa, String modelo, int anoFabricacao, double quilometragem) {
            this.placa = placa;
            this.modelo = modelo;
            this.anoFabricacao = anoFabricacao;
            this.quilometragem = quilometragem;
        }

        public void exibirDetalhes() {
            System.out.println("Placa: " + placa);
            System.out.println("Modelo: " + modelo);
            System.out.println("Ano de Fabricação: " + anoFabricacao);
            System.out.printf("Quilometragem: %.2f km%n", quilometragem);
            System.out.println("-------------------------");
        }

        public void registrarViagem(double km) {
            if (km > 0) {
                quilometragem += km;
                System.out.printf("Viagem registrada: %.2f km%n", km);
            } else {
                System.out.println("Distância inválida. Informe um valor maior que zero.");
            }
        }
    }

    public static void ATX6(Scanner scanner) {
        System.out.println("Digite a placa do carro");
        String placa = scanner.nextLine();
        System.out.println("Digite o modelo do carro");
        String modelo = scanner.nextLine();
        System.out.println("Digite o ano de fabricacao do carro");
        int anoFrabic = scanner.nextInt();
        System.out.println("Digite a quilometragem do carro");
        int quilometragem = scanner.nextInt();

        System.out.println("Digite quantos kilometros foram rodados");
        int km = scanner.nextInt();


        Veiculo veiculo = new Veiculo(placa, modelo, anoFrabic, quilometragem);

        System.out.println("Detalhes dos veículos:");
        veiculo.exibirDetalhes();

        System.out.println("Registrando viagens...");
        veiculo.registrarViagem(km);

        System.out.println("\nDetalhes após as viagens:");
        veiculo.exibirDetalhes();
    }

    public static class Aluno {
        private final String nome;
        private final String matricula;
        private final double[] notas = new double[3];

        public Aluno(String nome, String matricula, double nota1, double nota2, double nota3) {
            this.nome = nome;
            this.matricula = matricula;
            this.notas[0] = nota1;
            this.notas[1] = nota2;
            this.notas[2] = nota3;
        }

        public double calcularMedia() {
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.length;
        }

        public void verificarAprovacao() {
            double media = calcularMedia();
            System.out.printf("Média final: %.2f%n", media);

            if (media >= 7) {
                System.out.println("Status: Aprovado ✅");
            } else {
                System.out.println("Status: Reprovado ❌");
            }
        }
    }

    public static void ATX7(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        double[] notas = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.printf("Digite a %dª nota: ", i + 1);
            notas[i] = scanner.nextDouble();
        }

        Aluno aluno = new Aluno(nome, matricula, notas[0], notas[1], notas[2]);
        System.out.println("\nResultado Final:");
        aluno.verificarAprovacao();
    }

    public static class Funcionario {
        protected String nome;
        protected double salarioBase;

        public Funcionario(String nome, double salarioBase) {
            this.nome = nome;
            this.salarioBase = salarioBase;
        }

        public double calcularSalarioFinal() {
            return salarioBase;
        }

        public void exibirSalario() {
            System.out.printf("%s - Salário Final: R$ %.2f%n", nome, calcularSalarioFinal());
        }
    }

    public static class Gerente extends Funcionario {

        public Gerente(String nome, double salarioBase) {
            super(nome, salarioBase);
        }

        @Override
        public double calcularSalarioFinal() {
            return salarioBase * 1.2;
        }
    }

    public static class Estagiario extends Funcionario {

        public Estagiario(String nome, double salarioBase) {
            super(nome, salarioBase);
        }

        @Override
        public double calcularSalarioFinal() {
            return salarioBase * 0.9;
        }
    }

    public static void ATX8(Scanner scanner) {
        System.out.println("Qual o nome do/a gerente?");
        String gerenteNome = scanner.nextLine();

        System.out.println("Quanto o/a gerente ganha?");
        double gerenteGanho = scanner.nextDouble();
        Gerente gerente = new Gerente(gerenteNome, gerenteGanho);

        System.out.println("Qual o nome do/a Estagiario?");
        String estagiaNome = scanner.nextLine();

        System.out.println("Quanto o/a estagiario ganha?");
        double estagiaGanho = scanner.nextDouble();
        Estagiario estagiario = new Estagiario(estagiaNome, estagiaGanho);

        System.out.println("Salários finais:");
        gerente.exibirSalario();
        estagiario.exibirSalario();
    }

    public static class ContaBancaria {
        private final String titular;
        private double saldo;

        public ContaBancaria(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito realizado com sucesso!");
            } else {
                System.out.println("Valor inválido para depósito.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Saque realizado com sucesso!");
            } else if (valor > saldo) {
                System.out.println("Saldo insuficiente para o saque.");
            } else {
                System.out.println("Valor inválido para saque.");
            }
        }

        public void exibirSaldo() {
            System.out.printf("Saldo atual da conta de %s: R$ %.2f%n", titular, saldo);
        }
    }

    public static void ATX9(Scanner scanner) {
        System.out.print("Digite o nome do titular da conta: ");
        String titular = scanner.nextLine();

        System.out.print("Digite o saldo inicial da conta: R$ ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(titular, saldoInicial);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir Saldo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirSaldo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void ATX10(Scanner scanner) {
        String nomeArquivo = "compras.txt";

        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Cadastro da Compra " + i + ":");

                System.out.print("Produto: ");
                String produto = scanner.nextLine();

                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();

                System.out.print("Preço unitário: R$ ");
                double precoUnitario = scanner.nextDouble();
                scanner.nextLine();

                writer.write(produto + "," + quantidade + "," + precoUnitario + "\n");

                System.out.println("Compra registrada com sucesso!\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }

        System.out.println("Compras registradas no arquivo:");
        File file = new File(nomeArquivo);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String linha = fileScanner.nextLine();
                String[] dados = linha.split(",");
                String produto = dados[0];
                int quantidade = Integer.parseInt(dados[1]);
                double precoUnitario = Double.parseDouble(dados[2]);

                System.out.printf("Produto: %s | Quantidade: %d | Preço Unitário: R$ %.2f\n", produto, quantidade, precoUnitario);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void ATX11(Scanner scanner, Random random) {
        Set<Integer> numerosSorteados = new HashSet<>();
        while (numerosSorteados.size() < 6) {
            int numero = random.nextInt(60) + 1;
            numerosSorteados.add(numero);
        }


        Set<Integer> numerosUsuario = new HashSet<>();
        System.out.println("Digite 6 números entre 1 e 60:");

        while (numerosUsuario.size() < 6) {
            System.out.print("Digite um número: ");
            int numeroUsuario = scanner.nextInt();
            if (numeroUsuario < 1 || numeroUsuario > 60) {
                System.out.println("Número inválido! Por favor, insira um número entre 1 e 60.");
            } else {
                numerosUsuario.add(numeroUsuario);
            }
        }

        Set<Integer> acertos = new HashSet<>(numerosSorteados);
        acertos.retainAll(numerosUsuario);

        System.out.println("Números sorteados: " + numerosSorteados);
        System.out.println("Seus números: " + numerosUsuario);
        System.out.println("Acertos: " + acertos);
        System.out.println("Você acertou " + acertos.size() + " números.");
    }

    public static void ATX12(Scanner scanner) {
        System.out.print("Digite o nome do primeiro usuário: ");
        String usuario1 = scanner.nextLine();

        System.out.print("Digite o nome do segundo usuário: ");
        String usuario2 = scanner.nextLine();

        String[] mensagens = new String[10];

        int indice = 0;

        while (indice < 10) {
            if (indice % 2 == 0) {
                System.out.print(usuario1 + ", digite sua mensagem: ");
            } else {
                System.out.print(usuario2 + ", digite sua mensagem: ");
            }
            mensagens[indice] = scanner.nextLine();
            indice++;
        }

        System.out.println("\n===== Histórico de Mensagens =====");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println(usuario1 + ": " + mensagens[i]);
            } else {
                System.out.println(usuario2 + ": " + mensagens[i]);
            }
        }

        System.out.println("\nObrigado por utilizarem o sistema! Boa sorte para vocês! 🚀");
    }

}