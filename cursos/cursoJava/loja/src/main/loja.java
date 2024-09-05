package main;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class loja {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();

        System.out.println("Enter product data:");
        System.out.print("Name:");
        product.name = sc.nextLine();
        
        System.out.print("Price:");
        product.price= sc.nextDouble();

        System.out.print("Quantity in Stock:");
        product.quantity= sc.nextInt();

        System.out.println("product data:"+product.toString());

        System.out.println("Enter de number of products to be added in stock:");
        int quantity = sc.nextInt();
        product.addProducts(quantity);

        System.out.println("Updated data: "+ product.toString());

        System.out.println("Enter the number of products to be remove from stock:");
        quantity = sc.nextInt();
        product.removeProducts(quantity);

        System.out.print("Updated data: "+ product.toString());

        sc.close();
    }
}