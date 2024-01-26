/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chain;

/**
 *
 * @author sjeew
 */
public class FlavorHandler implements IceCreamCustomizationHandler{
   private IceCreamCustomizationHandler nextHandler;

    public void setNextHandler(IceCreamCustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(IceCream iceCream) {
        // Handle flavor customization
        // ...

        // Pass the request to the next handler if exists
        if (nextHandler != null) {
            nextHandler.handleRequest(iceCream);
        }
    }  
}
