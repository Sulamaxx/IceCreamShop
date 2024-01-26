/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author sjeew
 */
public class IceCream {
    private String flavor;
    private List<String> toppings;
    private List<String> syrups;
    private double price;

    public IceCream(){}
    
    public IceCream(String flavor, List<String> toppings, List<String> syrups, double price) {
        this.flavor = flavor;
        this.toppings = toppings;
        this.syrups = syrups;
        this.price = price;
    }

    public void customize() {
        // Logic for customization
    }

    public double calculatePrice() {
        // Logic for price calculation
        return price;
    }

    public void setFlavor(String flavor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setToppings(List<String> toppings) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setSyrups(List<String> syrups) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
