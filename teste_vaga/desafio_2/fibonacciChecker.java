import java.util.Scanner;

public class fibonacciChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();
        int a = 0;
        int b = 1;
        boolean pertence = false;
        if (numero == a || numero == b) {
            pertence = true;
        }
        else{
            while (b <= numero) {
                int proximo = a + b;
                a = b;
                b = proximo;
                if (b == numero) {
                    pertence = true;
                    break;
                }
            }
        }
        if (pertence) {
            System.out.println("O número " + numero + " pertence à sequência de fibonacci");
            
        }
        else{
            System.out.println("O número " + numero + " não pertence à sequência de fibonacci");
        }
        scanner.close();
    }
}
