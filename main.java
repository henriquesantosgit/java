public class Main {
    public static void main(String[] args) {
    

        int[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrizB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        // Matriz resultado ,armazena o resultado da soma
        int[][] matrizResultado = new int[3][3];

       //i para linhas ,j para colunas
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        // Exibir o resultado
        System.out.println("Resultado:");
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(matrizResultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}
