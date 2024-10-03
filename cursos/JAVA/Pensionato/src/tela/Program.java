package tela;

import java.util.Scanner;

import entities.Rooms;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rooms[] room = new Rooms[10];
		
		System.out.println("Digite o numero de hospedes:");
		int numeroHospedes = sc.nextInt();
		
		for (int i = 0; i < numeroHospedes; i++) {
			System.out.println(i);
			
			System.out.println("Name:");
			String nome = sc.next();
			System.out.println("Email:");
			String email = sc.next();
			System.out.println("Room:");
			int quarto = sc.nextInt();
			
			 room[quarto] = new Rooms(nome, email, quarto);
		}
		
		 System.out.println("\nQuartos ocupados:");
	        
	        for (int i = 0; i < room.length; i++) {
	            if (room[i] != null) {
	            	System.out.println(i+"-"+room[i].getNome()+","+room[i].getEmail()+"@gmail.com");
	            }
	        }
		sc.close();
	}

}
