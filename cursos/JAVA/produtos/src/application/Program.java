package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProducts;
import entities.Products;
import entities.UsedProducts;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("enter the number of products:");
		int n = sc.nextInt();

		List<Products> list = new ArrayList<>(n) {
		};

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i);
			System.out.print("imported, common or used?:");
			char typeItem = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("name: ");
			String name = sc.next();
			System.out.print("price: ");
			double price = sc.nextDouble();

			if (typeItem == 'i') {
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				Products product = new ImportedProducts(name, price, customsFee);
				list.add(product);
			}

			if (typeItem == 'u') {
				System.out.println("manufacture date (DD/MM/YYYY):");
				String dateinput = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					Date manufactureDate = sdf.parse(dateinput);
					Products product = new UsedProducts(name, price, manufactureDate);
					list.add(product);
				} catch (Exception e) {
					System.out.println("Invalid date format.");
				}

			}

			if (typeItem == 'c') {
				Products product = new Products(name, price);
				list.add(product);
			}

		}

		System.out.println();
		System.out.println("Price tags:");
		for (Products product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}
}
