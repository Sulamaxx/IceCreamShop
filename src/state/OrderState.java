/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package state;

/**
 *
 * @author sjeew
 */
public interface OrderState {
    void processOrder(Order order);
    void cancelOrder(Order order);
}
