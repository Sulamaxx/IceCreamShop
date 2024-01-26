/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author sjeew
 */
public class IceCreamDecorator {
     private IceCream iceCream;
    private List<String> extraFeatures;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
        this.extraFeatures = new ArrayList<>();
    }

    public void addFeature(String feature) {
        extraFeatures.add(feature);
    }

    public double calculatePrice() {
        // Logic for calculating price with extra features
        double basePrice = iceCream.calculatePrice();
        double additionalCost = extraFeatures.size() * 1.50; // Assuming each extra feature costs $1.50
        return basePrice + additionalCost;
    }
}
