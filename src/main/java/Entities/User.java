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


}