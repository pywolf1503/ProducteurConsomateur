package threads;

import api.collection.Limiters;
import api.collection.Notifiers;
import entities.AEntrepreneur;
import utilities.Console;
import utilities.SemaphoreManager;

/**
 * The Entrepreneur class represents an entity that implements the Runnable interface
 * and is responsible for monitoring stock levels in a factory and adjusting production
 * accordingly.
 */
public class Entrepreneur extends AEntrepreneur implements Runnable {

    /**
     * The run method is the main entry point for the thread. It continuously monitors
     * stock levels and adjusts production in response to certain conditions.
     */
    @Override
    public void run() {
        while (true) {
            if(getFactory().isProduction()){
                if(isMaximumStock()){
                    getFactoryThread().interrupt();
                    getFactory().setProduction(false);
                    Console.print("Factory: Stopped working!");
                }
            }
            else{
                if(isMinimumStock()){
                    getFactory().setProduction(true);
                    setFactoryThread(new Thread(getFactory()));
                    getFactoryThread().start();
                    Console.print("Factory: Started working!");
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

