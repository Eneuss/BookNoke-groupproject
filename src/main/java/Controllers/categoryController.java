/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entities.Category;
import static Entities.Category.categories;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class categoryController {
    //Method that let's and admin add a new category
    public static void addCategory(Scanner scanner) {
        System.out.print("Enter the name of the new category: ");
        String name = scanner.nextLine();
        categories.add(new Category(name));
        System.out.println("Category added successfully: " + name);
    }
}
