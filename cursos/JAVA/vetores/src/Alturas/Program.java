package Alturas;

import java.util.Locale;
import java.util.Scanner;

import Entities.Pessoas;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o numero de pessoas:");
		int aux = sc.nextInt();

		Pessoas[] pessoa = new Pessoas[aux];

		for (int i = 0; i < aux; i++) {
			System.out.printf("pessoa[%d]:%n", i);
			sc.nextLine();
			System.out.println("Nome:");
			String nome = sc.nextLine();
			System.out.println("idade:");
			int idade = sc.nextInt();
			System.out.println("Altura:");
			double altura = sc.nextDouble();
			pessoa[i] = new Pessoas(nome, idade, altura);
		}
		
		double soma = 0;
		
		for(int i= 0; i<pessoa.length;i++) {
			soma += pessoa[i].getAltura();
			
		}
		double sum = soma / pessoa.length;
		System.out.printf("Media das alturas:%.2f",sum);
		sc.close();
	}
}
//porcentagem de quantos sao abaixco de 16 anos
