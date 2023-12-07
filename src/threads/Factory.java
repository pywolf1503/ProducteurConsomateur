package threads;

import api.collection.Notifiers;
import entities.AFactory;
import utilities.Console;

public class Factory extends AFactory implements Runnable {
    @Override
    public void run() {
        while(true){
            if(isProduction()){
                int product = produce();
                Console.print(Notifiers.FACTORY_PRODUCE + "Product ID: " + Integer.toString(product));
                getEntrepreneur().addStock(product);
                Console.print(Notifiers.STOCK_ADDED + "Product ID: " + Integer.toString(product));
            }
        }
    }
}
