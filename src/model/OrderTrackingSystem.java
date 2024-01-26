/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sjeew
 */
public class OrderTrackingSystem {
    private int orderID;
    private String status;

    public OrderTrackingSystem(int orderID, String status) {
        this.orderID = orderID;
        this.status = status;
    }

    public void updateStatus(String newStatus) {
        // Logic for updating order status
    }

    public void notifyUser() {
        // Logic for notifying the user
    }

}
