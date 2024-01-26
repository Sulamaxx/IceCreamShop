package observer;

import java.util.List;
import java.util.ArrayList;
import model.Order;

public class User implements OrderObserver{

    private int userID;
    private String username;
    private String email;
    private String password;
    private List<String> favorites;

    public User(int userID, String username, String email, String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.favorites = new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void saveFavorite(String favorite) {
        favorites.add(favorite);
    }

    public void reorderFavorite(String favorite) {
        // Logic to reorder favorite
    }

    public boolean login(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    // ... existing fields and methods ...

    // Observer Pattern: Update method to receive order status changes
    @Override
    public void update(Order order) {
        // Notify user about the order status change
        System.out.println("Order status for Order ID " + order.getOrderID() + " changed to: " + order.getOrderStatus());
    }
    
    
}
