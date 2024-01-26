/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

/**
 *
 * @author sjeew
 */
public class OutForDeliveryOrderState implements OrderState{
     @Override
    public void processOrder(Order order) {
        // Logic for processing an order out for delivery
        order.setOrderStatus("Delivered");
    }

    @Override
    public void cancelOrder(Order order) {
        // Logic for canceling an order out for delivery
        order.setOrderStatus("Cancelled");
    }
}
