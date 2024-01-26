/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package builder;

import java.util.List;
import model.IceCream;

/**
 *
 * @author sjeew
 */
public interface IceCreamBuilder {
    void buildFlavor(String flavor);
    void buildToppings(List<String> toppings);
    void buildSyrups(List<String> syrups);
    IceCream getResult();
}
