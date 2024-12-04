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
public class User {
    protected String userName;
    protected String email;
    protected String password;
    
    //list of the users subscribed to the program
    public static List<User> users = new ArrayList<>();
    private static User loggedInUser = null;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Method to set some default users
    public static void initializeDefUsers(){
        users.add(new User("Alice80","alice@gmail.com", "12345"));
        users.add(new User("Mark","Mark@gmail.com", "password"));
        
        users.add(new Admin("enea","enea@gmail.com","12"));
    }
    
    @Override
    public String toString() {
        return "User [Username=" + userName + ", Email=" + email + ", Password=" + password + "]";
    }

    //Method that checks if a user is already logged in otherwise enables the login session if the credentials match
    public static boolean login(String username, String password) {
            if (loggedInUser != null) {
                System.out.println("Error: A user is already logged in.");
                return false;  //Prevent login if a user is already logged in
            }

            //Find the user with matching credentials
            for (User user : users) {
                user.toString();
                if (user.userName.equals(username) && user.password.equals(password)) {
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
                System.out.println("Goodbye " + loggedInUser.userName + "!");
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