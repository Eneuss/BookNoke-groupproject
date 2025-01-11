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
            System.out.println("1. Group member A");
            System.out.println("2. Group member B");
            System.out.println("3. Group member C");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // register
                    menuCenter.groupMemberA(scanner);
                    break;
                case 2:
                    menuCenter.groupMemberB(scanner);
                    break;
                    
                case 3:
                    menuCenter.groupMemberC(scanner);
                    return ;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}