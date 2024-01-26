/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sjeew
 */
public class Payment {
     private int orderID;
    private String paymentMethod;
    private double amount;

    public Payment(int orderID, String paymentMethod, double amount) {
        this.orderID = orderID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public void processPayment() {
        // Logic for payment processing
    }

    public void applyLoyaltyPoints() {
        // Logic for applying loyalty points
    }

}
