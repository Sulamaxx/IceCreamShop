/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author sjeew
 */
public class PlaceOrderCommand implements Command{
     private Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.processOrder();
    }
}
