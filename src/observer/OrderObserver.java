/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import model.Order;

/**
 *
 * @author sjeew
 */
public interface OrderObserver {
    void update(Order order);
}
