package threads;

import api.collection.Limiters;
import api.collection.Notifiers;
import entities.AFactory;
import utilities.Console;
import utilities.SemaphoreManager;

/**
 * The {@code Factory} class represents a factory in a simulation.
 * It extends the abstract class {@code AFactory} and implements the {@code Runnable} interface
 * to allow it to be executed as a separate thread.
 */
public class Factory extends AFactory implements Runnable {

    /**
     * The run method represents the main functionality of the factory thread.
     * It runs in an infinite loop, continuously producing and adding products to the stock.
     * The production and stock updates are synchronized using semaphores.
     */
    @Override
    public void run() {
        while(true){
            if(isProduction()){
            try {
                // Acquire an empty slot in the buffer
                SemaphoreManager.empty.acquire(1);
            } catch (InterruptedException e) {
                Console.print("Factory: Stopped working!");
            }
            try{
                // Acquire the mutex to ensure exclusive access to shared resources
                SemaphoreManager.mutex.acquire(1);
            } catch (InterruptedException e) {
                // Propagate any interruption as a runtime exception
                throw new RuntimeException(e);
            }
                // Produce a new product
                int product = produce();
                // Print a notification about the produced product
                Console.print(Console.GREEN + Notifiers.FACTORY_PRODUCE + Console.CYAN_BOLD + "Product ID: " + product);
                // Add the produced product to the entrepreneur's stock
                getEntrepreneur().addStock(product);
                // Print a notification about the added product to the stock
                //Console.print(Notifiers.STOCK_ADDED + "Product ID: " + product);
            // Release the mutex to allow other threads to access shared resources
            SemaphoreManager.mutex.release(1);
            // Signal that a slot in the buffer is now full
            SemaphoreManager.full.release(1);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }
    }
}
