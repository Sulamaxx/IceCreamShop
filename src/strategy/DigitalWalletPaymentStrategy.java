/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author sjeew
 */
public class DigitalWalletPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        // Logic for processing digital wallet payment
        System.out.println("Digital wallet payment processed for amount: " + amount);
    }
}
