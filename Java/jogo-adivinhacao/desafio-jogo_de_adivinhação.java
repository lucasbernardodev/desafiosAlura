import java.util.Random;
import java.util.Scanner;

public class desafioAlura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite 1 para iniciar o jogo ou outro número para sair: ");
        int situacaoJogo = sc.nextInt();

        while (situacaoJogo == 1) {
            System.out.println("Jogo iniciado!");
            int num = new Random().nextInt(10);
            System.out.println("Tente adivinhar um número de 1 à 10: ");
            int chances = 4;
            for (int i = 0; i < 5; i++) {
                int leituraUsuario = sc.nextInt();
                if (leituraUsuario == num){
                    System.out.println("Parabéns!");
                    System.out.println("Você acertou");
                    i = 6;
                } else {
                    System.out.println("Errado, tente novamente.");
                    if (chances != 0) {
                        System.out.println("Restam " + chances + " tentativas.");
                        chances -= 1;
                    } else
                    {
                        System.out.println("Você perdeu!");
                    }
                }
            }
            System.out.println("O número sorteado era: " + num);
            System.out.println("Digite 1 para jogar novamente ou -1 para sair: ");
            int validadorFinal = 0;
            while (validadorFinal != 1){
                int decisaoFinal = sc.nextInt();
                switch (decisaoFinal){
                    case 1:situacaoJogo = 1;
                        validadorFinal = 1;
                        break;
                    case -1:situacaoJogo = -1;
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
}
