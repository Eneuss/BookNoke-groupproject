/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Admin
 */
public class Accessory extends Product {
    private String accessoryType;

    public Accessory(String name, double price, Category category, String accessoryType) {
        super(name, price, category);
        this.accessoryType = accessoryType;
    }

    public String getAccessoryType() {
        return accessoryType;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Type: " + accessoryType;
    }
}

