/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Enea Rina
 */

public class Admin extends User {
    
    // Creation of lists of products and categories
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();

    static {
        // Adding default categories and products 
        categories.add(new Category("Fantasy"));
        categories.add(new Category("Novel"));
        categories.add(new Category("Merch"));

        
        products.add(new Book("1984", 9.99, categories.get(1), "George Orwell"));
        products.add(new Book("Harry Potter and the philosopher stone", 7.99, categories.get(0), "Harper Lee"));
        products.add(new Accessory("Bookmark", 1.50, categories.get(2), "Stationery"));
        products.add(new Accessory("Reading Light", 12.99, categories.get(2), "Electronics")); // No category
    }

    public Admin(String username, String email, String password) {
        super(username, email, password);
    }

      //Method for Admin to add a new user (User or either Admin)
    public static void addNewUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        // for loop to check duplicates
        for (User user : users) {
            if (user.getUserName().equals(username) || user.getEmail().equals(email)) {
                System.out.println("Error: Username or email is already in use.");
                return;
            }
        }

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Is this user an admin? (yes/no): ");
        String isAdmin = scanner.nextLine().toLowerCase();

        
        // Selection of a regular User or an Admin
        if (isAdmin.equals("yes")) {
            Admin newAdmin = new Admin(username, email, password);
            users.add(newAdmin);
            System.out.println("Admin added: " + newAdmin);
        } else {
            User newUser = new User(username, email, password);
            users.add(newUser);
            System.out.println("User added: " + username);
        }
    }
    
    //Method to view all the users present in the program
    public static void viewAllUsers() {
        System.out.println("\nList of All Users:");
        for (User user : users) {
            String role = (user instanceof Admin) ? "Admin" : "Regular User";
            System.out.println("Role: " + role + ", Username: " + user.getUserName() + ", Email: " + user.getEmail() + ", Password: " + user.getPassword());
        }
    }
    
    //Method to edit the credentials of a selected user
    public static void editUser(Scanner scanner) {
        System.out.print("Enter the username of the user to edit: ");
        String targetUsername = scanner.nextLine();

        User userToEdit = null;
        
        //for loop to find the user with the specified username
        for (User user : users) {
            if (user.getUserName().equals(targetUsername)) {
                userToEdit = user;
                break;
            }
        }

        if (userToEdit == null) {
            System.out.println("User with username " + targetUsername + " not found.");
            return;
        }

        //edit the user details
        System.out.println("Editing user: " + userToEdit.getUserName());
        
        System.out.print("Enter new username (leave blank to keep current): ");
        String newUsername = scanner.nextLine();
        if (!newUsername.isEmpty()) {
            userToEdit.setUserName(newUsername);
        }

        System.out.print("Enter new email (leave blank to keep current): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            userToEdit.setEmail(newEmail);
        }

        System.out.print("Enter new password (leave blank to keep current): ");
        String newPassword = scanner.nextLine();
        if (!newPassword.isEmpty()) {
            userToEdit.setPassword(newPassword);
        }
        System.out.println("User details updated successfully.");
    }
    
    
        //Method that delete a selected user based on their username
    public static void deleteUser(Scanner scanner) {
        System.out.print("Enter the username of the user to delete: ");
        String targetUsername = scanner.nextLine();

        User userToDelete = null;

        //for loop to find the user with the specified username
        for (User user : users) {
            if (user.getUserName().equals(targetUsername)) {
                userToDelete = user;
                break;
            }
        }
        
        //if statement that prevents to delete the current active admin
        if (userToDelete == Admin.getLoggedInUser()){
            System.out.println("You cannot delete the current logged in user!!!");
            return;
        }

        if (userToDelete == null) {
            System.out.println("User with username '" + targetUsername + "' not found.");
            return;
        }

        // Confirm deletion
        System.out.print("Are you sure you want to delete " + targetUsername + "? (yes/no): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            users.remove(userToDelete);
            System.out.println("User '" + targetUsername + "' has been deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    //Method that let's and admin add a new category
    public static void addCategory(Scanner scanner) {
        System.out.print("Enter the name of the new category: ");
        String name = scanner.nextLine();
        categories.add(new Category(name));
        System.out.println("Category added successfully: " + name);
    }
    
    
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
     for (int i = 0; i < categories.size(); i++) {
         System.out.println((i + 1) + ". " + categories.get(i));
     }
     int categoryIndex = scanner.nextInt() - 1;
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

    System.out.println("Select a category:");
    for (int i = 0; i < categories.size(); i++) {
        System.out.println((i + 1) + ". " + categories.get(i));
    }
    int categoryIndex = scanner.nextInt() - 1;
    scanner.nextLine();

    if (categoryIndex < 0 || categoryIndex >= categories.size()) {
        System.out.println("Invalid category selection.");
        return;
    }

    Category category = categories.get(categoryIndex);

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
