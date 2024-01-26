/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package state;

/**
 *
 * @author sjeew
 */
public class PlacedOrderState implements OrderState{
     @Override
    public void processOrder(Order order) {
        // Logic for processing a placed order
        order.setOrderStatus("In Preparation");
    }

    @Override
    public void cancelOrder(Order order) {
        // Logic for canceling a placed order
        order.setOrderStatus("Cancelled");
    }
}
