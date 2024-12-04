/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
class Product {
    private static int idCounter = 1;
    protected int id;
    protected String name;
    protected double price;
    protected Category category;

    public Product(String name, double price, Category category) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.category = category;
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
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price +
               (category != null ? ", Category: " + category : "");
    }
        
}

