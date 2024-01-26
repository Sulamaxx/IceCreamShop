/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;
import model.Order;
/**
 *
 * @author sjeew
 */
public class NotificationService implements OrderObserver{
     @Override
    public void update(Order order) {
        System.out.println("Notification: Order status updated - " + order.getStatus());
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}
