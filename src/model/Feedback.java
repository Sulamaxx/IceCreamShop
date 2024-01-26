/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sjeew
 */
public class Feedback {
     private int orderID;
    private int rating;
    private String comment;

    public Feedback(int orderID, int rating, String comment) {
        this.orderID = orderID;
        this.rating = rating;
        this.comment = comment;
    }

    public void submitFeedback() {
        // Logic for submitting feedback
    }

}
