/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;
import java.util.List;
import model.IceCream;
/**
 *
 * @author sjeew
 */
public class IceCreamDirector {
    private IceCreamBuilder builder;

    public IceCreamDirector(IceCreamBuilder builder) {
        this.builder = builder;
    }

    // Builder Pattern: Construct complex ice cream orders
    public IceCream constructIceCream(String flavor, List<String> toppings, List<String> syrups) {
        builder.buildFlavor(flavor);
        builder.buildToppings(toppings);
        builder.buildSyrups(syrups);
        return builder.getResult();
    }
}
