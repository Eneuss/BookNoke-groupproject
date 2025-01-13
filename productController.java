/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entities.Accessory;
import Entities.Admin;
import Entities.Book;
import Entities.Category;
import java.util.Scanner;
import static Entities.Category.categories;
import Entities.Product;
import static Entities.Product.products;
import java.util.ArrayList;

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
     int categoryIndex = scanner.nextInt();
     scanner.nextLine(); // Consume newline

     if (categoryIndex < 0 || categoryIndex >= categories.size()) {
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
    
    
    // Function made by Valerio Gerardi
    public static ArrayList<Book> searchBook(Scanner scanner) {
        ArrayList<Book> items = new ArrayList<>();
        System.out.println("Search Book");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the keyword: ");
        String keyword = scanner.nextLine();

        boolean searchByTitle = (choice == 1);
        boolean found = false;
        int i = 1;
        System.out.println("\nSearch Results:");
        for (Product product : products) {
            if (product instanceof Book) {
                Book book = (Book) product;

                // Check for title or author match
                if ((searchByTitle && book.getName().equalsIgnoreCase(keyword)) ||
                    (!searchByTitle && book.getAuthor().equalsIgnoreCase(keyword))) {
                    System.out.println(i + ".  " + book.toString());
                    i++;
                    items.add(book);
                    found = true;
                }
            }
        }
        

        if (!found) {
            System.out.println("No books found matching your search.");
            return items;
        }
        
        return items;
    
    
    }
    
    // Function made by Luis
    
    public static void modifyProduct(Scanner scanner) {
        //Check privileges
        if (!(login.getLoggedInUser() instanceof Admin)) {
            System.out.println("You don't have permissions to complete this action.");
            System.out.println("Please log in as an administrator");            
            return;                        
        }
        
        //Dipslay products
        if (products.isEmpty()) {
            System.out.println("No products available to modify");
            return;
        }
        
        System.out.println("\n--- Modify Product ---");
        System.out.println("Available Products:");
        for (Product product : products) {
             System.out.println(product.toString());
        }
        
        //Select a product by ID
        System.out.print("Enter the ID of the product to modify: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                selectedProduct = product;
                break;
            }
        }
        
        if (selectedProduct == null) {
            System.out.println("Product with ID" + productId + " not found.");
            return;
        }
        
        // Input and validate new values
        System.out.println("Modifying product: " + selectedProduct.toString());
        
        //Modify name
        System.out.print("Enter new name (don't modify to keep:" + selectedProduct.getName() + "): ");
        
        //Modify price
        System.out.print("Enter new price (current: $" + selectedProduct.getPrice() + "): ");
        double newPrice;
        String priceInput = scanner.nextLine();
        if (!priceInput.isEmpty()) {
            try {
                newPrice = Double.parseDouble(priceInput);
                selectedProduct.setPrice(newPrice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Keeping current price.");
            }
        }
        
        //Modify category
        System.out.println("Available Categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + ". " + categories.get(i).getName());
        }
        System.out.print("Enter new category index (current: " + selectedProduct.getCategory().getName() + "): ");
        String categoryInput = scanner.nextLine();
        if (!categoryInput.isEmpty()) {
            try {
                int categoryIndex = Integer.parseInt(categoryInput);
                if (categoryIndex  >= 0 && categoryIndex < categories.size()) {
                    selectedProduct.setCategory(categories.get(categoryIndex));            
                } else {
                    System.out.println("Invalid category index Keeping current category.");
                }
            }  catch (NumberFormatException e) {
                System.out.println("Invalid input. Keeping current category.");
            }
        }
        //Confirm update
    
        System.out.println("Product updated successfully: " + selectedProduct.toString());
    } 
    
    
}   
    
