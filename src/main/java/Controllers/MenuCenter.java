/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.Scanner;
import Entities.Admin;
import Entities.User;
/**
 *
 * @author Admin
 */
public class MenuCenter {
    
    
    public static void AdminMenu(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add a new item or category");
            System.out.println("2. View All Regular Users");
            System.out.println("3. Change an user details");
            System.out.println("4. Delete user");
            System.out.println("5. Edit Product list or categorys"); //Luis part
            System.out.println("6. Delete Product"); //Luis part
            System.out.println("7. Logout");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("---Inventory Update!---");
                    System.out.println("What do you want to add:");
                    System.out.println("1. Add a new Book");
                    System.out.println("2. Add a new item accessory");
                    System.out.println("3. Add a new category");
                    System.out.println("4. Return to menu");
                    System.out.print("Select an option: ");
                    int inventory = scanner.nextInt();
                    scanner.nextLine();
                    switch (inventory) {
                        case 1:
                            Admin.addBook(scanner);
                            break;
                        case 2:
                            Admin.addAccessory(scanner);
                            break;
                        case 3:
                            Admin.addCategory(scanner);
                            break;
                        case 4:
                            break;
                        case 5:
                            System.out.println("Invalid selection!!!");
                            break;
                    }
                    break;
                case 2:
                    
                    Admin.viewAllUsers();
                    break;
                case 3:
                    Admin.editUser(scanner);
                    break;
                case 4:
                    Admin.deleteUser(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    Admin.logout();
                    return;// Exit the admin section and returns to main menu
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
                
    }
    
    
    
    public static void UserMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Search book"); // Valerio part
            System.out.println("2. Buy a Book or Accessory");
            System.out.println("3. View order history");
            System.out.println("4. Logout");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    //connect to the function that lets you search for a book
                    break;
                case 2:
                    //buy an item and also use the function of the case 1 to show the list again
                    break;
                case 3:
                    //function that displays the order history
                    break;
                case 4:
                    System.out.println("Logging out from user menu.");
                    User.logout();
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
