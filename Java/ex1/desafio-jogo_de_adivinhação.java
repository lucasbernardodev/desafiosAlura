import java.util.Random;
import java.util.Scanner;

public class DesafioAlura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int situacaoJogo = -1;

        while (situacaoJogo != -1) {
            System.out.println("Digite 1 para iniciar o jogo ou -1 para sair: ");
            situacaoJogo = scanner.nextInt();

            if (situacaoJogo == 1) {
                System.out.println("Jogo iniciado!");

                int numeroSorteado = new Random().nextInt(10);
                int chances = 4;

                for (int i = 0; i < 5; i++) {
                    System.out.println("Tente adivinhar um número de 1 a 10: ");
                    int leituraUsuario = scanner.nextInt();

                    if (leituraUsuario == numeroSorteado) {
                        System.out.println("Parabéns! Você acertou");
                        break;
                    } else {
                        System.out.println("Errado, tente novamente.");

                        if (chances != 0) {
                            System.out.println("Restam " + chances + " tentativas.");
                            chances--;
                        } else {
                            System.out.println("Você perdeu!");
                            break;
                        }
                    }
                }

                System.out.println("O número sorteado era: " + numeroSorteado);

                int validadorFinal = 0;

                while (validadorFinal != 1) {
                    System.out.println("Digite 1 para jogar novamente ou -1 para sair: ");
                    int decisaoFinal = scanner.nextInt();

                    switch (decisaoFinal) {
                        case 1:
                            situacaoJogo = 1;
                            validadorFinal = 1;
                            break;
                        case -1:
                            situacaoJogo = -1;
                            validadorFinal = 1;
                            break;
                        default:
                            System.out.println("Número inválido, digite uma opção válida: ");
                            validadorFinal = 2;
                            break;
                    }
                }
            }
        }

        scanner.close();
        System.out.println("O jogo foi encerrado.");
    }
}
