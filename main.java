import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Matriz 6x2 
        String[][] matriz = {
            {"usuario1", "senha1"},
            {"usuario2", "senha2"},
            {"usuario3", "senha3"},
            {"usuario4", "senha4"},
            {"usuario5", "senha5"},
            {"usuario6", "senha6"}
        };

        // Solicita ao usuário o login e a senha
        System.out.println("Digite o usuário: ");
        String usuario = scan.nextLine();
        
        System.out.println("Digite a senha: "); 
        String senha = scan.nextLine();
    //precisa iniciar uma booleana ,é necessário
        boolean valido = false;
        
   //
        for (int i = 0; i < matriz.length; i++) {
            if (usuario.equals(matriz[i][0]) && senha.equals(matriz[i][1])) {
                valido = true;
                break; // Se encontrou, não precisa continuar verificando
            }
        }

        // Exibe o resultado para o usuário
        if (valido) {
            System.out.println("Acesso permitido");
        } else {
            System.out.println("Acesso negado");
        }

        
    }
}
