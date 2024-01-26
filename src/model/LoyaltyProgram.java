/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sjeew
 */
public class LoyaltyProgram {
    private int points;
    private double discounts;
    private int freeItems;

    public LoyaltyProgram() {
        this.points = 0;
        this.discounts = 0.0;
        this.freeItems = 0;
    }

    public void earnPoints() {
        // Logic for earning points
    }

    public double calculateDiscount() {
        // Logic for calculating discounts
        return discounts;
    }

    public void redeemPoints() {
        // Logic for redeeming points
    }
}
