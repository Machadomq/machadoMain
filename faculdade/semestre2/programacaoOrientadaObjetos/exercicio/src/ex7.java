
import java.util.Scanner;

public class ex7 {
    
    public static void main(String[] args) {
        float base, altura;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a base do triangulo:");
        base=scanner.nextFloat();

        System.out.println("Digite a altura do triangulo:");
        altura=scanner.nextFloat();

        System.out.println("Area="+(base * altura) / 2);
    }
}
