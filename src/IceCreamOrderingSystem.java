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
        if (toppings == null) toppings = new ArrayList<>();
        toppings.add(topping);
        return this;
    }

    public IceCreamOrderBuilder addSyrup(String syrup) {
        if (syrups == null) syrups = new ArrayList<>();
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

// Command Pattern
interface IceCreamCommand {
    void execute();
}

class PlaceOrderCommand implements IceCreamCommand {
    private IceCreamOrder order;

    public PlaceOrderCommand(IceCreamOrder order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus("In Preparation");
        System.out.println("Order placed and is being prepared.");
    }
}

class FeedbackCommand implements IceCreamCommand {
    private IceCreamOrder order;
    private String feedback;

    public FeedbackCommand(IceCreamOrder order, String feedback) {
        this.order = order;
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        System.out.println("Feedback received for order: " + order.getFlavor() + " - " + feedback);
    }
}

// Decorator Pattern
abstract class IceCreamDecorator extends IceCreamOrder {
    protected IceCreamOrder iceCreamOrder;

    public IceCreamDecorator(IceCreamOrder iceCreamOrder) {
        super(iceCreamOrder.getFlavor(), iceCreamOrder.getToppings(), iceCreamOrder.getSyrups(), iceCreamOrder.getQuantity());
        this.iceCreamOrder = iceCreamOrder;
    }

    @Override
    public String getStatus() {
        return iceCreamOrder.getStatus();
    }
}

class GiftWrappingDecorator extends IceCreamDecorator {
    public GiftWrappingDecorator(IceCreamOrder iceCreamOrder) {
        super(iceCreamOrder);
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " with Gift Wrapping";
    }
}

class SpecialPackagingDecorator extends IceCreamDecorator {
    public SpecialPackagingDecorator(IceCreamOrder iceCreamOrder) {
        super(iceCreamOrder);
    }

    @Override
    public String getStatus() {
        return super.getStatus() + " with Special Packaging";
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

// Other classes remain unchanged

public class IceCreamOrderingSystem {
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
        iceCreamOrder.setStatus("In Preparation");

        // Builder Pattern
        IceCreamOrderBuilder orderBuilder = new IceCreamOrderBuilder()
                .setFlavor("Vanilla")
                .addTopping("Chocolate Chips")
                .addSyrup("Strawberry")
                .setQuantity(1);
        IceCreamOrder vanillaOrder = orderBuilder.build();

        // Strategy Pattern
        PaymentProcessor creditCardPaymentProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardPaymentProcessor.processPayment(15.99);

        // Command Pattern
        IceCreamOrder feedbackOrder = new IceCreamOrderBuilder()
                .setFlavor("Strawberry")
                .addTopping("Whipped Cream")
                .addSyrup("Chocolate")
                .setQuantity(1)
                .build();
        IceCreamCommand feedbackCommand = new FeedbackCommand(feedbackOrder, "Delicious!");
        feedbackCommand.execute();

        // Decorator Pattern
        IceCreamOrder decoratedOrder = new GiftWrappingDecorator(new SpecialPackagingDecorator(vanillaOrder));
        System.out.println("Decorated Order Status: " + decoratedOrder.getStatus());

        // State Pattern
        OrderContext orderContext = new OrderContext();
        orderContext.processOrder(vanillaOrder);
        System.out.println("Vanilla Order Status: " + vanillaOrder.getStatus());
    }
}