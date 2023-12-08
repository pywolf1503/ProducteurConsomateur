package threads;

import api.collection.Notifiers;
import entities.AFactory;
import utilities.Console;
import utilities.SemaphoreManager;

public class Factory extends AFactory implements Runnable {
    @Override
    public void run() {
        while(true){
            try {
                SemaphoreManager.empty.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                SemaphoreManager.mutex.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int product = produce();
            Console.print(Notifiers.FACTORY_PRODUCE + "Product ID: " + Integer.toString(product));
            getEntrepreneur().addStock(product);
            Console.print(Notifiers.STOCK_ADDED + "Product ID: " + Integer.toString(product));
            SemaphoreManager.mutex.release();
            SemaphoreManager.full.release();
        }
    }
}
