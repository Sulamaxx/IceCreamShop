
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

    private String flavor;
    private List<String> toppings;
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
    void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    void setSyrups(List<String> syrups) {
        this.syrups = syrups;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
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

public class IceCreamOrderingSystemTest {

    public static void main(String[] args) {
        // Observer Pattern
        NotificationService notificationService = new NotificationService();
        IceCreamOrder iceCreamOrder = new IceCreamOrderBuilder()
                .setFlavor("Chocolate")
                .addTopping("Sprinkles")
                .addSyrup("Caramel")
                .setQuantity(2)
                .build();
        iceCreamOrder.addObserver(notificationService);
        iceCreamOrder.notifyObservers();
        iceCreamOrder.setStatus("In Preparation");

        // Builder Pattern
        IceCreamOrderBuilder orderBuilder = new IceCreamOrderBuilder()
                .setFlavor("Vanilla")
                .addTopping("Chocolate Chips")
                .addSyrup("Strawberry")
                .setQuantity(1);
        IceCreamOrder vanillaOrder = orderBuilder.build();
        vanillaOrder.addObserver(notificationService);
        vanillaOrder.setStatus("In Preparation");

        // Strategy Pattern
        PaymentProcessor creditCardPaymentProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardPaymentProcessor.processPayment(15.99);

        // Chain of Responsibility Pattern
        IceCreamOrder customizationOrder = new IceCreamOrder();
        customizationOrder.addCustomizationHandler(new FlavorHandler());
        customizationOrder.addCustomizationHandler(new ToppingHandler());
        customizationOrder.addCustomizationHandler(new SyrupHandler());
        customizationOrder.processCustomizations();

        // State Pattern
        OrderContext orderContext = new OrderContext();
        orderContext.processOrder(vanillaOrder);
        System.out.println("Vanilla Order Status: " + vanillaOrder.getStatus());
    }
}
