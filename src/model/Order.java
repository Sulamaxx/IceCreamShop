/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import observer.OrderObserver;

/**
 *
 * @author sjeew
 */
public class Order {

    private List<OrderObserver> observers = new ArrayList<>();
    private String flavor;
    private List<String> toppings;
    private List<String> syrups;
    private int quantity;
    private String status;

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public String getStatus() {
        return status;
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
}
