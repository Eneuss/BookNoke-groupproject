/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.booknook;

import Entities.Admin;
import java.util.Scanner;
import Entities.User;
import Controllers.menuCenter;
import Controllers.login;
import Controllers.adminController;
import Entities.Category;
import Entities.Product;
/**
 *
 * @author Admin
 */
public class BookNook {

    public static void main(String[] args) {
        User.initializeDefUsers();
        Category.initializeDefCat();
        Product.initializeDefProd();
        Scanner scanner = new Scanner(System.in);

        // initial menu
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // register
                    adminController.addNewUser();
                    break;
                case 2:
                    /* Part E of group member B Enea Rina that implements the
                        login functionality to the program, making a distinguish
                        between regular users and admins
                    */ 
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    boolean loginSuccess = login.login(username, password);
                
                    if (loginSuccess) {
                        // Check if the logged-in user is an Admin
                        if (login.getLoggedInUser() instanceof Admin) {
                            System.out.println("Admin privileges granted.");
                            menuCenter.AdminMenu(scanner, (Admin) login.getLoggedInUser());
                        } else {
                            System.out.println("Regular user logged in.");
                            menuCenter.UserMenu(scanner);
                        }
                    }
                    break;
                    
                case 3:
                    return ;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}