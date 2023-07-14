import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao Banco Alura!");
        System.out.println("Digite seu nome de usuário:");
        String nomeCliente = sc.nextLine();

        System.out.println("Agora digite sua senha:");
        int senhaCliente = sc.nextInt(); // senha ficticia

        String tipoContaCliente = "Corrente";
        double saldoCliente = 1000.00;

        System.out.println("Bem-vindo de volta " + nomeCliente);
        System.out.printf("""
                ----------------------------------
                Informações da conta

                Nome:                 %s
                Tipo de conta:        %s
                Saldo inicial:        %.2f
                ----------------------------------

                Operações
                1 - Consultar meu saldo
                2 - Depositar
                3 - Sacar
                4 - Sair

                """, nomeCliente, tipoContaCliente, saldoCliente);

        boolean iniciarOperacoes = true;
        while (iniciarOperacoes) {
            int decisaoOperacoes = sc.nextInt();

            if (decisaoOperacoes == 4) {
                System.out.println("Fechando aplicação...");
                System.out.println("----------------------------------");
                System.out.println("Obrigado por usar o banco Alura");
                System.out.println("Banco Alura, o banco dos desenvolvedores!");
                iniciarOperacoes = false;
            }

            while (decisaoOperacoes > 4 || decisaoOperacoes < 0) {
                System.out.println("""
                        ----------------------------------
                        Opção inválida, tente novamente

                        Operações
                        1 - Consultar meu saldo
                        2 - Depositar
                        3 - Sacar
                        4 - Sair
                        """);
                decisaoOperacoes = sc.nextInt();
            }

            while (decisaoOperacoes < 4 && decisaoOperacoes > 0) {
                switch (decisaoOperacoes) {
                    case 1 -> {
                        System.out.println("Saldo atual: R$" + String.format("%.2f", saldoCliente));
                        decisaoOperacoes = -1;
                    }
                    case 2 -> {
                        System.out.println("Digite o valor que deseja depositar:");
                        double valorDepositoCliente = sc.nextDouble();
                        saldoCliente += valorDepositoCliente;
                        System.out.println("Valor depositado!");
                        System.out.println("Saldo atual: R$" + String.format("%.2f", saldoCliente));
                        decisaoOperacoes = -1;
                    }
                    case 3 -> {
                        System.out.println("Digite o valor para saque:");
                        double valorSaqueCliente = sc.nextDouble();
                        if (saldoCliente > valorSaqueCliente && valorSaqueCliente != 0) {
                            saldoCliente -= valorSaqueCliente;
                            System.out.println("Valor disponivel para saque!");
                            System.out.println("Retire o valor na agência mais próxima.");
                            System.out.println("Saldo atual: R$" + String.format("%.2f", saldoCliente));
                        } else {
                            System.out.println("Valor indisponivel para saque!");
                            System.out.println("Tente realizar a operação novamente com outro valor.");
                        }
                        decisaoOperacoes = -1;
                    }
                }
            }

            if (decisaoOperacoes == -1) {
                System.out.println("1 - Voltar ao menu");
                System.out.println("2 - Fechar aplicativo");
                int verificaProximaInteracao = sc.nextInt();

                switch (verificaProximaInteracao) {
                    case 1 -> System.out.printf("""
                            ----------------------------------
                            Informações da conta

                            Nome:                 %s
                            Tipo de conta:        %s
                            Saldo inicial:        %.2f
                            ----------------------------------

                            Operações
                            1 - Consultar meu saldo
                            2 - Depositar
                            3 - Sacar
                            4 - Sair

                            """, nomeCliente, tipoContaCliente, saldoCliente);

                    case 2 -> {
                        System.out.println("Fechando aplicação...");
                        System.out.println("----------------------------------");
                        System.out.println("Obrigado por usar o banco Alura");
                        System.out.println("Banco Alura, o banco dos desenvolvedores!");
                        iniciarOperacoes = false;
                    }

                    default -> {
                        System.out.println("Opção inválida, tente novamente");
                        System.out.println("1 - Voltar ao menu");
                        System.out.println("2 - Fechar aplicativo");
                        verificaProximaInteracao = sc.nextInt();

                        while (verificaProximaInteracao != 1 && verificaProximaInteracao != 2) {
                            System.out.println("Opção inválida, tente novamente");
                            System.out.println("1 - Voltar ao menu");
                            System.out.println("2 - Fechar aplicativo");
                            verificaProximaInteracao = sc.nextInt();
                        }
                    }
                }
            }
        }
    }
}
