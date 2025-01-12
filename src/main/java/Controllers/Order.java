/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.ArrayList;
import java.util.Scanner;
import Entities.Book;
import Entities.Accessory;
import Entities.Product;
import static Entities.Product.products;

/**
 *
 * @author Valerio Gerardi
 */

//Class created by Valerio Gerardi to implement part b and c of the group assesment
public class Order {
    private Product product;
    private int quantity;
    private static ArrayList<Order> order = new ArrayList<>();
    
    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product.toString() + ", Quantity: " + quantity;
    }

    

    

    
    
    public static void buyBook(Scanner scanner){
        ArrayList<Book> book = productController.searchBook(scanner);
        if (book.isEmpty()){
            return;
        }
        
        int choice;
        do{
            System.out.println("\nSelect the book that you want: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice <= 0 || choice > book.size()){
                System.out.println("\nIncorrect selection please try again!");
            }
            
        }while(choice<=0 || choice> book.size());
        
        
        int quantity;
        do{
            System.out.println("\nType the quantity you want to buy: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            if(quantity <= 0){
                System.out.println("\nIncorrect selection please try again!");
            }
            
        }while(quantity <= 0);
        
        Book selectedBook = book.get(choice - 1);
        order.add(new Order(selectedBook, quantity));
        System.out.println("\n" + quantity + " copies of \"" + selectedBook.getName() + "\" added to your order.");

        for (Product product : products) {
            if (product.getId() == selectedBook.getId()) {
                product.setSales(quantity);
            }
        }
    }
        
    public static void buyAccessory(Scanner scanner) {
        ArrayList<Accessory> accessoryList = new ArrayList<>();
        System.out.println("\nAccessory list:");
        int i=1;
        for (Product product : products) {
            if (product instanceof Accessory) {
                Accessory acc = (Accessory) product;
                System.out.println(i + ".  " + acc.toString());
                accessoryList.add(acc);
                i++;
            }
        }
        
        int selection;
        do{
            System.out.println("\nSelect what accessory to buy: ");
            selection = scanner.nextInt();
            scanner.nextLine();
            if(selection <= 0 || selection > i){
                System.out.println("\nIncorrect selection please try again!");
            }
            
        }while(selection <= 0 || selection > i);
        
        int quantity;
        do{
            System.out.println("\nType the quantity you want to buy: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            if(quantity <= 0 ){
                System.out.println("\nIncorrect selection please try again!");
            }
            
        }while(quantity <= 0);
        
        Accessory selectedAcc = accessoryList.get(selection - 1);
        order.add(new Order(selectedAcc, quantity));
        
        System.out.println("\n" + quantity + " copies of \"" + selectedAcc.getName() + "\" added to your order.");

        for (Product product : products) {
            if (product.getId() == selectedAcc.getId()) {
                product.setSales(quantity);
            }
        }
        
    }
    
    public static void orderHistory(){
        System.out.println("\n----Your order History----");
        int i = 1;
        for(Order list: order){
            System.out.println("Product:");
            System.out.println(i + ". " + list.getProduct());
            System.out.println("\nQuantity:");
            System.out.println(list.getQuantity());
            System.out.println("------------------------------------------------------");
            i++;
        }
    }
    
}
