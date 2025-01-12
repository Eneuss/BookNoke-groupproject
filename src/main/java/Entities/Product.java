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
        products.add(new Book("1984", 9.99, categories.get(1), "George Orwell"));
        products.add(new Book("test1", 10.99, categories.get(1), "George Orwell"));
        products.add(new Book("Harry Potter and the philosopher stone", 7.99, categories.get(0), "Harper Lee"));
        products.add(new Accessory("Bookmark", 1.50, categories.get(0), "Stationery"));
        products.add(new Accessory("Reading Light", 12.99, categories.get(0), "Electronics")); // No category

    }
        
}

