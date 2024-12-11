/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entities.Admin;
import Entities.User;
import static Entities.User.users;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class adminController {
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
        if (userToDelete == login.getLoggedInUser()){
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
}
