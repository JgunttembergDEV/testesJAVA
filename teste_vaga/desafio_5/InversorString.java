import java.util.Scanner;

public class InversorString {
    public static void main(String[] args) {
        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Definindo uma string previamente ou permitindo entrada do usuário
        System.out.print("Digite uma string para inverter (ou pressione Enter para usar a pré-definida): ");
        String input = scanner.nextLine();
        
        // Se o usuário não digitar nada, usar uma string pré-definida
        if (input.isEmpty()) {
            input = "Exemplo de string a ser invertida";
        }

        // Invertendo a string
        String stringInvertida = inverterString(input);
        
        // Exibindo o resultado
        System.out.println("String original: " + input);
        System.out.println("String invertida: " + stringInvertida);

        // Fechando o scanner
        scanner.close();
    }

    // Método para inverter a string
    public static String inverterString(String str) {
        // Verifica se a string é nula ou vazia
        if (str == null || str.isEmpty()) {
            return str; // Retorna a string original se for nula ou vazia
        }
        
        char[] caracteres = new char[str.length()];
        
        // Preenchendo o array com os caracteres da string original
        for (int i = 0; i < str.length(); i++) {
            caracteres[i] = str.charAt(i);
        }

        // Invertendo os caracteres
        StringBuilder stringInvertida = new StringBuilder();
        for (int i = caracteres.length - 1; i >= 0; i--) {
            stringInvertida.append(caracteres[i]);
        }
        
        return stringInvertida.toString();
    }
}
