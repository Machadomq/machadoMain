import java.util.Scanner;


public class ex11 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double velocidade;

        System.out.println("digite a velocidade do carro:");
        velocidade=scanner.nextDouble();

        if (velocidade>80){
            System.out.println(velocidade+" Km/h (Acima da velocidade)");
        } 
        else System.out.println(velocidade+" Km/h (Dentro do limite)");

    }
}
