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
public class ConcreteIceCreamBuilder implements IceCreamBuilder{
     private IceCream iceCream;

    public ConcreteIceCreamBuilder() {
        this.iceCream = new IceCream();
    }

    @Override
    public void buildFlavor(String flavor) {
        iceCream.setFlavor(flavor);
    }

    @Override
    public void buildToppings(List<String> toppings) {
        iceCream.setToppings(toppings);
    }

    @Override
    public void buildSyrups(List<String> syrups) {
        iceCream.setSyrups(syrups);
    }

    @Override
    public IceCream getResult() {
        return iceCream;
    }
}
