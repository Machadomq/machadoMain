
import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nome1 = "mestre do universo";

        System.out.println("Digite um nome:");
        String nome2 = scanner.nextLine();

        nome1 = "ola";
        nome2 = "mundo";

        System.out.println(nome1 + " " + nome2);

    }
}
