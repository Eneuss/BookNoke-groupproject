/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import static Entities.Category.categories;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Product {
    // Creation of lists of products
    public static ArrayList<Product> products = new ArrayList<>();
    
    
    private static int idCounter = 1;
    protected int id;
    protected String name;
    protected double price;
    protected Category category;
    protected int sales;

    public Product(String name, double price, Category category) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.category = category;
        sales = 0;
    }

    public int getId() {
        return id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setSales(int sale) {
        this.sales= this.sales + sale;
    }

    public int getSales() {
        return sales;
    }
    
    
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Category: " + category + ", Sales: " + sales;
               //(category != null ? ", Category: " + category : "");
    }
    
        
    
    public static void initializeDefProd(){
        products.add(new Book("1984", 9.99, categories.get(3), "George Orwell"));
        products.add(new Book("Harry Potter and the Philosopher's Stone", 7.99, categories.get(1), "J.K. Rowling"));
        products.add(new Book("To Kill a Mockingbird", 6.99, categories.get(2), "Harper Lee"));
        products.add(new Book("The Hobbit", 8.99, categories.get(1), "J.R.R. Tolkien"));
        products.add(new Book("Dune", 11.99, categories.get(3), "Frank Herbert")); 
        products.add(new Book("The Catcher in the Rye", 7.49, categories.get(2), "J.D. Salinger")); 
        products.add(new Book("The Girl with the Dragon Tattoo", 8.99, categories.get(4), "Stieg Larsson"));
        products.add(new Book("Sapiens: A Brief History of Humankind", 12.99, categories.get(5), "Yuval Noah Harari")); 
        products.add(new Book("Pride and Prejudice", 5.99, categories.get(2), "Jane Austen")); 
        products.add(new Book("The Da Vinci Code", 9.49, categories.get(4), "Dan Brown")); 
        
        products.add(new Accessory("Bookmark", 1.50, categories.get(0), "Stationery")); 
        products.add(new Accessory("Reading Light", 12.99, categories.get(0), "Electronics")); 
        products.add(new Accessory("Book Stand", 9.99, categories.get(0), "Stationery"));
        products.add(new Accessory("Notebook", 5.99, categories.get(0), "Stationery"));
        products.add(new Accessory("Pen Set", 3.49, categories.get(0), "Stationery")); 
        products.add(new Accessory("Library Tote Bag", 15.99, categories.get(0), "Fashion")); 
        products.add(new Accessory("E-Reader Case", 18.49, categories.get(0), "Electronics"));
        products.add(new Accessory("Book Cover Protector", 7.49, categories.get(0), "Stationery")); 

    }
        
}

