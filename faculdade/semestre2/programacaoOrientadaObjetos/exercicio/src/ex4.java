
import java.util.Scanner;

public class ex4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();

        System.out.println("Informe suas notas (enter para confirmar nota):");
        float nota1 = scanner.nextFloat();
        float nota2 = scanner.nextFloat();
        float nota3 = scanner.nextFloat();
        float nota4 = scanner.nextFloat();

        System.out.println((nota1 + nota2 + nota3 + nota4) / 4);
    }
}
