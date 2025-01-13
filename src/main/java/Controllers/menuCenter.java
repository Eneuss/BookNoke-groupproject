/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.Scanner;
import Entities.Admin;
import Controllers.Order;

/**
 *
 * @author Admin
 */
public class menuCenter {
    
    // Part of Valerio Gerardi 
    public static void groupMemberA(Scanner scanner) {
        while(true) {
            System.out.println("\nGroup member A 'Gerardi Valerio' functionalities:");
            System.out.println("1. Search Book");
            System.out.println("2. Buy product");
            System.out.println("3. View order history");
            System.out.print("4. Return to Group members menu ");
            System.out.print("\nSelect an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    productController.searchBook(scanner);
                    break;
                case 2:
                    System.out.println("\n-----Buy-----");
                    System.out.println("1. Buy book");
                    System.out.println("2. Buy accessory");
                    System.out.print("3. Return to Group member A menu ");
                    System.out.print("\nSelect an option: ");

                    int choiceProduct = scanner.nextInt();
                    scanner.nextLine();
                    switch (choiceProduct){
                        case 1:
                            Order.buyBook(scanner);
                            break;
                        case 2:
                            Order.buyAccessory(scanner);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 3:
                    Order.orderHistory();
                    break;
                case 4:
                    return; // you can leave this as it is to exit this menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    
    // Part of Enea Rina
    public static void groupMemberB(Scanner scanner) {
        while(true) {
            System.out.println("\nGroup member B 'Rina Enea' functionalities:");
            System.out.println("1. Add a new item or category");
            System.out.println("2. Log in as admin or regular user");
            System.out.println("3. List of all users");
            System.out.println("4. Change details of an active user in the system");
            System.out.print("5. Return to Group members menu ");
            System.out.print("\nSelect an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Questo e il primo menu: "+ choice);
            switch (choice) {
                case 1:
                    System.out.println("\n---Inventory Update!---");
                    System.out.println("What do you want to add:");
                    System.out.println("1. Add a new Book");
                    System.out.println("2. Add a new item accessory");
                    System.out.println("3. Add a new category");
                    System.out.println("4. Return to previous menu");
                    System.out.print("Select an option: ");
                    int inventory = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Questo e il menu dei libri: "+ inventory);
                    switch (inventory) {
                        case 1:
                            productController.addBook(scanner);
                            break;
                        case 2:
                            productController.addAccessory(scanner);
                            break;
                        case 3:
                            categoryController.addCategory(scanner);
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.println("Invalid selection!!!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("\n---Login funtionalities---");
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Return to previous menu");
                    System.out.print("Select an option: ");
                    int choiceLogin = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Questo e il menu login: "+ choiceLogin);

                    switch (choiceLogin) {
                        case 1: // register
                            adminController.addNewUser();
                            break;
                        case 2:
                            System.out.print("Enter Username: ");
                            String username = scanner.nextLine();
                            System.out.print("Enter Password: ");
                            String password = scanner.nextLine();
                            boolean loginSuccess = login.login(username, password);

                            if (loginSuccess) {
                                // Check if the logged-in user is an Admin
                                if (login.getLoggedInUser() instanceof Admin) {
                                    System.out.println("Admin privileges granted.");
                                    login.getLoggedInUser();
                                } else {
                                    System.out.println("Regular user logged in.");
                                }
                            }
                            
                            if (loginSuccess) {
                                login.logout();
                            }
                            break;
                    
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Siamo qua");
                    adminController.viewAllUsers();
                    break;
                case 4:
                    adminController.editUser(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
    
    
    // Part of Luis Antonio
    public static void groupMemberC(Scanner scanner) {
        while(true) {
            System.out.println("\nGroup member C 'Luis Antonio' functionalities:");
            System.out.println("1. List of products");
            System.out.println("2. Signup account");
            System.out.println("3. Modify products");
            System.out.print("4. Return to Group members menu ");
            System.out.print("\nSelect an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    productController.viewAllProducts();
                    break;
                case 2:
                    adminController.addNewUser();  // Enea and Luis share this function
                    break;
                case 3:
                    System.out.print("\nDefault credentials: admin | admin");
                    System.out.print("\nEnter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    boolean loginSuccess = login.login(username, password);
                
                    if (loginSuccess) {
                        // Check if the logged-in user is an Admin
                        if (login.getLoggedInUser() instanceof Admin) {
                            System.out.println("\nAdmin privileges granted.");
                            productController.modifyProduct(scanner);
                        } else {
                            System.out.println("\nRegular users cannot access this section.");
                        }
                    }
                    
                    if (loginSuccess){
                        login.logout();
                    }
                    
                    
                    break;
                case 4:
                    
                    return;  // you can leave this as it is to exit this menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
