/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Entities.User;
import static Entities.User.users;

/**
 *
 * @author Enea Rina
 */
public class login {
    private static User loggedInUser = null;
        //Method that checks if a user is already logged in otherwise enables the login session if the credentials match
        public static boolean login(String username, String password) {
            if (loggedInUser != null) {
                System.out.println("Error: A user is already logged in.");
                return false;  //Prevent login if a user is already logged in
            }

            //Find the user with matching credentials
            for (User user : users) {
                user.toString();
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                    loggedInUser = user;  //Set the logged-in user
                    System.out.println("Login successful! Welcome " + username);
                    return true;
                }
            }

            System.out.println("Error: Invalid username or password.");
            return false;  //Invalid credentials check
        }

        // Logout method
        public static void logout() {
            if (loggedInUser != null) {
                System.out.println("Goodbye " + loggedInUser.getUserName() + "!");
                loggedInUser = null;
            } else {
                System.out.println("No user is logged in.");
            }
        }
        

        //Check the currently logged-in user
        public static User getLoggedInUser() {
            return loggedInUser;
        }
}
