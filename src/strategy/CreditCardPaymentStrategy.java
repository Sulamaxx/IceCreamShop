/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author sjeew
 */
public class CreditCardPaymentStrategy implements PaymentStrategy{
     @Override
    public void processPayment(double amount) {
        // Logic for processing credit card payment
        System.out.println("Credit card payment processed for amount: " + amount);
    }
}
