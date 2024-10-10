package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("how many employees will be registered?");
		int numeroFuncionarios = sc.nextInt();
		
		List<Employees> list = new ArrayList<>();

		for (int i = 0; i < numeroFuncionarios; i++) {
			System.out.println("emplyoee #" + i);
			
			System.out.print("id: ");
			Integer id = sc.nextInt();
			
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.next();
			
			System.out.print("Salary:");
			Double salary = sc.nextDouble();

			Employees emp = new Employees(id, name, salary);

			list.add(emp);
		}

		System.out.println("enter the employee id that will have salary increase: ");
		int idInserido = sc.nextInt();
		
		Integer pos = hasId(list, idInserido);
		
		if (pos == null) {
			System.out.println("Not found ID");
		} else {
			System.out.print("Enter the percentage:");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		System.out.println();
		System.out.println("List of Employees:");
		for (Employees emp : list) {
			System.out.println(emp);
		}
		sc.close();
	}

	public static Integer hasId(List<Employees> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
