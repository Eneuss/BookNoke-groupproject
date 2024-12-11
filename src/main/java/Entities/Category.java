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
        categories.add(new Category("Accessory"));
        categories.add(new Category("Fantasy"));
        categories.add(new Category("Novel"));
    }
}