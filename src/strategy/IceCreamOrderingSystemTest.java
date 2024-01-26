package strategy;


import java.util.ArrayList;
import java.util.List;

// Observer Pattern
interface OrderObserver {

    void update(IceCreamOrder order);
}

class NotificationService implements OrderObserver {

    @Override
    public void update(IceCreamOrder order) {
        System.out.println("Notification: Order status updated - " + order.getStatus());
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}

// Builder Pattern
class IceCreamOrderBuilder {

    private String flavor;
    private List<String> toppings;
    private List<String> syrups;
    private int quantity;

    public IceCreamOrderBuilder setFlavor(String flavor) {
        this.flavor = flavor;
        return this;
    }

    public IceCreamOrderBuilder addTopping(String topping) {
        if (toppings == null) {
            toppings = new ArrayList<>();
        }
        toppings.add(topping);
        return this;
    }

    public IceCreamOrderBuilder addSyrup(String syrup) {
        if (syrups == null) {
            syrups = new ArrayList<>();
        }
        syrups.add(syrup);
        return this;
    }

    public IceCreamOrderBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public IceCreamOrder build() {
        IceCreamOrder order = new IceCreamOrder();
        order.setFlavor(flavor);
        order.setToppings(toppings);
        order.setSyrups(syrups);
        order.setQuantity(quantity);
        return order;
    }
}

// Strategy Pattern
interface PaymentStrategy {

    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}

class DigitalWalletPayment implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing digital wallet payment: $" + amount);
    }
}

class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

// Chain of Responsibility Pattern
interface IceCreamCustomizationHandler {

    void handleCustomization(IceCreamOrder order);
}

class FlavorHandler implements IceCreamCustomizationHandler {

    @Override
    public void handleCustomization(IceCreamOrder order) {
        // Handle flavor customization logic
        System.out.println("Handling flavor customization");
    }
}

class ToppingHandler implements IceCreamCustomizationHandler {

    @Override
    public void handleCustomization(IceCreamOrder order) {
        // Handle topping customization logic
        System.out.println("Handling topping customization");
    }
}

class SyrupHandler implements IceCreamCustomizationHandler {

    @Override
    public void handleCustomization(IceCreamOrder order) {
        // Handle syrup customization logic
        System.out.println("Handling syrup customization");
    }
}

class IceCreamOrder {

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void setSyrups(List<String> syrups) {
        this.syrups = syrups;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setObservers(List<OrderObserver> observers) {
        this.observers = observers;
    }

    public void setCustomizationHandlers(List<IceCreamCustomizationHandler> customizationHandlers) {
        this.customizationHandlers = customizationHandlers;
    }

    private String flavor;
    private List<String> toppings;

    public String getFlavor() {
        return flavor;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getSyrups() {
        return syrups;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<OrderObserver> getObservers() {
        return observers;
    }

    public List<IceCreamCustomizationHandler> getCustomizationHandlers() {
        return customizationHandlers;
    }
    private List<String> syrups;
    private int quantity;
    private String status;

    private List<OrderObserver> observers = new ArrayList<>();
    private List<IceCreamCustomizationHandler> customizationHandlers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void addCustomizationHandler(IceCreamCustomizationHandler handler) {
        customizationHandlers.add(handler);
    }

    public void processCustomizations() {
        for (IceCreamCustomizationHandler handler : customizationHandlers) {
            handler.handleCustomization(this);
        }
    }

    // Other getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    // Additional methods as needed
}

// State Pattern
interface OrderState {

    void processOrder(IceCreamOrder order);
}

class PlacedState implements OrderState {

    @Override
    public void processOrder(IceCreamOrder order) {
        order.setStatus("In Preparation");
        order.processCustomizations();
    }
}

class InPreparationState implements OrderState {

    @Override
    public void processOrder(IceCreamOrder order) {
        order.setStatus("Out for Delivery");
    }
}

class OutForDeliveryState implements OrderState {

    @Override
    public void processOrder(IceCreamOrder order) {
        order.setStatus("Delivered");
    }
}

// Context class for State Pattern
class OrderContext {

    private OrderState orderState;

    public OrderContext() {
        this.orderState = new PlacedState();
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void processOrder(IceCreamOrder order) {
        orderState.processOrder(order);
    }
}

// Additional code for User class
class User {

    private String username;
    private List<IceCreamOrder> favorites = new ArrayList<>();
    private int loyaltyPoints;

    public User(String username) {
        this.username = username;
    }

    public void saveFavoriteOrder(IceCreamOrder order) {
        favorites.add(order);
    }

    public void reorderFavoriteOrder(int index) {
        if (index >= 0 && index < favorites.size()) {
            IceCreamOrder favoriteOrder = favorites.get(index);
            System.out.println("Reordering favorite: " + favoriteOrder.getFlavor());
        } else {
            System.out.println("Invalid index for reordering.");
        }
    }

    public void earnLoyaltyPoints(int points) {
        loyaltyPoints += points;
        System.out.println("Earned " + points + " loyalty points. Total: " + loyaltyPoints);
    }
}

// Additional code for OrderDecorator class
class OrderDecorator {

    public static IceCreamOrder decorateWithGiftWrapping(IceCreamOrder order) {
        return new GiftWrappingDecorator(order);
    }

    public static IceCreamOrder decorateWithSpecialPackaging(IceCreamOrder order) {
        return new SpecialPackagingDecorator(order);
    }
}

// Additional code for SpecialsManager class
class SpecialsManager {

    private List<String> seasonalSpecials = new ArrayList<>();

    public void introduceSpecial(String special) {
        seasonalSpecials.add(special);
        System.out.println("New seasonal special introduced: " + special);
    }

    public void managePromotions() {
        // Logic for managing promotions
        System.out.println("Managing promotions for seasonal specials.");
    }
}

// Additional code for MappingService class
class MappingService {

    public int calculateDeliveryTime() {
        // Logic for calculating delivery time
        return 30; // Dummy value for demonstration
    }

    public String provideDeliveryEstimate() {
        int deliveryTime = calculateDeliveryTime();
        return "Estimated delivery time: " + deliveryTime + " minutes.";
    }
}

// Additional code for OrderProcessor class
class OrderProcessor {

    private List<IceCreamOrder> orderQueue = new ArrayList<>();

    public void processOrder(IceCreamOrder order) {
        orderQueue.add(order);
        System.out.println("Processing order: " + order.getFlavor());
    }

    public void trackOrderStatus(IceCreamOrder order) {
        System.out.println("Tracking order status: " + order.getStatus());
    }

    public void notifyUser(IceCreamOrder order) {
        // Logic for notifying the user
        System.out.println("Notifying user about order status: " + order.getStatus());
    }
}

// Additional code for FeedbackSystem class
class FeedbackSystem {

    public void collectFeedback(IceCreamOrder order, String feedback) {
        System.out.println("Feedback collected for order " + order.getFlavor() + ": " + feedback);
    }

    public void displayHighlyRatedCombinations() {
        // Logic for displaying highly-rated combinations
        System.out.println("Displaying highly-rated ice cream combinations.");
    }
}

// Additional code for IceCreamShop class
class IceCreamShop {

    private String[] iceCreamFlavors;
    private String[] toppings;
    private String[] syrups;
    private List<String> seasonalSpecials = new ArrayList<>();

    public void introduceSeasonalSpecial(String special) {
        seasonalSpecials.add(special);
        System.out.println("New seasonal special introduced: " + special);
    }

    public void managePromotions() {
        // Logic for managing promotions
        System.out.println("Managing promotions for seasonal specials.");
    }
}

// Decorator Pattern
class GiftWrappingDecorator extends IceCreamOrder {

    private IceCreamOrder decoratedOrder;

    public GiftWrappingDecorator(IceCreamOrder decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public String getStatus() {
        return "Gift Wrapped " + decoratedOrder.getStatus();
    }
}

class SpecialPackagingDecorator extends IceCreamOrder {

    private IceCreamOrder decoratedOrder;

    public SpecialPackagingDecorator(IceCreamOrder decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public String getStatus() {
        return "Special Packaging " + decoratedOrder.getStatus();
    }
}

public class IceCreamOrderingSystemTest {

    public static void main(String[] args) {
        // Creating instances for testing
        NotificationService notificationService = new NotificationService();
        IceCreamOrderBuilder orderBuilder = new IceCreamOrderBuilder();
        PaymentProcessor creditCardPaymentProcessor = new PaymentProcessor(new CreditCardPayment());
        OrderContext orderContext = new OrderContext();
        OrderProcessor orderProcessor = new OrderProcessor();
        FeedbackSystem feedbackSystem = new FeedbackSystem();

        // Creating a user
        User user = new User("JohnDoe");

        // Creating an ice cream order
        IceCreamOrder iceCreamOrder = orderBuilder
                .setFlavor("Chocolate")
                .addTopping("Sprinkles")
                .addSyrup("Caramel")
                .setQuantity(2)
                .build();

        // Observer Pattern
        iceCreamOrder.addObserver(notificationService);
        iceCreamOrder.setStatus("In Preparation");

        // Builder Pattern
        IceCreamOrder vanillaOrder = orderBuilder
                .setFlavor("Vanilla")
                .addTopping("Chocolate Chips")
                .addSyrup("Strawberry")
                .setQuantity(1)
                .build();

        // Strategy Pattern
        creditCardPaymentProcessor.processPayment(15.99);

        // Chain of Responsibility Pattern
        IceCreamOrder customizationOrder = new IceCreamOrder();
        customizationOrder.addCustomizationHandler(new FlavorHandler());
        customizationOrder.addCustomizationHandler(new ToppingHandler());
        customizationOrder.addCustomizationHandler(new SyrupHandler());
        customizationOrder.processCustomizations();

        // State Pattern
        orderContext.processOrder(vanillaOrder);
        System.out.println("Vanilla Order Status: " + vanillaOrder.getStatus());

        // Additional functionalities
        user.saveFavoriteOrder(vanillaOrder);
        user.reorderFavoriteOrder(0);
        user.earnLoyaltyPoints(10);

        IceCreamOrder decoratedOrder = OrderDecorator.decorateWithGiftWrapping(iceCreamOrder);
        decoratedOrder = OrderDecorator.decorateWithSpecialPackaging(decoratedOrder);

        // Specials and promotions
        IceCreamShop iceCreamShop = new IceCreamShop();
        iceCreamShop.introduceSeasonalSpecial("Summer Delight");
        iceCreamShop.managePromotions();

        // Order processing
        orderProcessor.processOrder(iceCreamOrder);
        orderProcessor.trackOrderStatus(iceCreamOrder);
        orderProcessor.notifyUser(iceCreamOrder);

        // Feedback system
        feedbackSystem.collectFeedback(iceCreamOrder, "Delicious!");
        feedbackSystem.displayHighlyRatedCombinations();
    }
}
