package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exception.ExceedWithdrawLimitException;
import exception.InsufficientBalanceException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc =new Scanner(System.in);
		
		
		System.out.println("Enter account data");
		System.out.print("Number:");
		int number =sc.nextInt();
		sc.nextLine();
		System.out.print("holder:");
		String holder =sc.nextLine();
		System.out.println("initial balance:");
		double initialBalance = sc.nextDouble();
		System.out.print("withdraw limit:");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, initialBalance, withdrawLimit);
		
		try {
			System.out.print("enter amount for withdraw:");
			double withdrawAmount =sc.nextDouble();
			acc.withDraw(withdrawAmount);
		}
		catch(ExceedWithdrawLimitException e){
			System.out.println("Erro:"+ e.getMessage());
		}
		catch(InsufficientBalanceException e) {
			System.out.println("Error:"+e.getMessage());
		}
		finally {
			System.out.println("fim do programa.");
		}
		sc.close();
	}
}
