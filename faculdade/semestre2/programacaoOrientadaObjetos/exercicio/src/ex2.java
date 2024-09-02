import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero:");
        int numero = scanner.nextInt();

        System.out.println("-----");
        for (int i = 0; i < 11; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}
