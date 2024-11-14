package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Products> list = new ArrayList<>();
		
		System.out.println("Enter file path:");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr);
		String sourcefolderStr = sourceFile.getParent();
		
		boolean success = new File(sourcefolderStr + "\\out").mkdir();
		
		String targetFileStr = sourcefolderStr+"\\out\\summary.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			
			String itemCsv = br.readLine();
			while(itemCsv !=null) {
				
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price= Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Products(name, price, quantity));
				
				itemCsv=br.readLine();
			}
			
			
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				
				for (Products item : list) {
					bw.write(item.getName()+ ","+String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr+" Created");
				
			}catch(IOException e) {
				System.out.println("Error writing file:" + e.getMessage());
			}
		}catch(IOException e) {
			System.out.println("Error writing file:" + e.getMessage());
		}
		
		
		
		sc.close();
	}
}
