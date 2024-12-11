/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entities.Accessory;
import Entities.Book;
import Entities.Category;
import java.util.Scanner;
import static Entities.Category.categories;
import Entities.Product;
import static Entities.Product.products;

/**
 *
 * @author Admin
 */
public class productController {
    // Method to add a new book
    public static void addBook(Scanner scanner) {
     System.out.print("Enter the book name: ");
     String name = scanner.nextLine();

     System.out.print("Enter the price: ");
     double price = scanner.nextDouble();
     scanner.nextLine();

     System.out.print("Enter the author: ");
     String author = scanner.nextLine();

     System.out.println("Select a category:");
     for (int i = 1; i < categories.size(); i++) {
         System.out.println((i) + ". " + categories.get(i));
     }
     int categoryIndex = scanner.nextInt() - 1;
     scanner.nextLine(); // Consume newline

     if (categoryIndex < 1 || categoryIndex >= categories.size()) {
         System.out.println("Invalid category selection.");
         return;
     }

     Category category = categories.get(categoryIndex);

     // Add the new book
     products.add(new Book(name, price, category, author));
     System.out.println("Book added successfully with ID: " + (products.size()));
    }
    
        //Method to add a new accessory
    public static void addAccessory(Scanner scanner) {
        System.out.print("Enter the accessory name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the accessory type: ");
        String type = scanner.nextLine();

        Category category = categories.get(0);

        // Add the new accessory
        products.add(new Accessory(name, price, category, type));
        System.out.println("Accessory added successfully with ID: " + (products.size()));
    }


    // Method to view all products
    public static void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("\nList of Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
    
