import java.util.Scanner;


public class ex8 {


    public static void main(String[] args) {
         double num1, num2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("digite dois numeros:");
        num1=scanner.nextDouble();
        num2=scanner.nextDouble();

        System.out.println("media="+(num1 + num2)/2);
    }
}
