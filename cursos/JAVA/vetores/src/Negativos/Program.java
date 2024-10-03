package Negativos;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite quantos nuemros voce deseja:");
		
		int aux= sc.nextInt();
		
		double[] vect= new double[aux];
		
		for (int i=0;i<vect.length;i++) {
			System.out.println("Digite um numero:");
			vect[i]= sc.nextDouble();
		}
		
		System.out.println("Numeros negativos");
		for (int i=0; i<vect.length;i++) {
			if(vect[i]<0) {
				System.out.println(vect[i]);
			}
		}
		
		
		sc.close();
	}
}
