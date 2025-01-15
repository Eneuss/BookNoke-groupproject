/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Category {
    // Creation of lists of categories
    public static ArrayList<Category> categories = new ArrayList<>();
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public static void initializeDefCat(){
        categories.add(new Category("Accessory")); //category ID: 0
        categories.add(new Category("Fantasy"));   //category ID: 1
        categories.add(new Category("Novel"));     //Category ID: 2
        categories.add(new Category("Science Fiction")); //Category ID: 3
        categories.add(new Category("Mystery"));       //Category ID: 4
        categories.add(new Category("Non-Fiction"));   // Category ID: 5
    }
}