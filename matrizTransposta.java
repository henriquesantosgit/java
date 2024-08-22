import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita o número de linhas e colunas da matriz
        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = scanner.nextInt();

        // Cria a matriz original
        int[][] matriz = new int[linhas][colunas];
        
        // Preenche a matriz com valores fornecidos pelo usuário
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Cria a matriz transposta
        int[][] matrizTransposta = new int[colunas][linhas];

        // Calcula a transposição da matriz
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizTransposta[j][i] = matriz[i][j];
            }
        }

        // Exibe a matriz original
        System.out.println("Matriz Original:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Exibe a matriz transposta
        System.out.println("Matriz Transposta:");
        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                System.out.print(matrizTransposta[i][j] + " ");
            }
            System.out.println();
        }


    }
}
