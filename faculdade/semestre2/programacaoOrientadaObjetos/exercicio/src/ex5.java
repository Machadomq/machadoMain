import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a temperatura em Celcius:");
        float C = scanner.nextFloat();

        System.out.println("Celcius:" + C);
        System.out.println("F:" + (C * 1.8 + 32));
        System.out.println("K:" + (C + 273.15));
        System.out.println("Re:" + (C * 0.8));
        System.out.println("Ra:" + (C * 1.8 + 32 + 459.67));
    }
}
