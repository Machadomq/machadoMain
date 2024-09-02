import java.util.Scanner;

public class ex12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int velocidade;

        System.out.println("Digite a velocidade do carro:");
        velocidade = scanner.nextInt();
        
        if (velocidade<40) System.out.println("Muito lento");
        if (velocidade>=40 && velocidade<60) System.out.println("lento");
        if (velocidade>=60 && velocidade<100) System.out.println("normal");
        if (velocidade>=100 && velocidade<120) System.out.println("rapido");
        if (velocidade>120) System.out.println("muito rapido");
    }
}
