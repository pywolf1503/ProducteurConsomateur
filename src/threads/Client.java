package threads;

import api.collection.Notifiers;
import entities.AClient;
import utilities.Console;
import utilities.SemaphoreManager;

/**
 * The {@code Client} class represents a client in a simulation.
 * It extends the abstract class {@code AClient} and implements the {@code Runnable} interface
 * to allow it to be executed as a separate thread.
 */
public class Client extends AClient implements Runnable {
    /**
     * The run method represents the main functionality of the client thread.
     * It runs in an infinite loop, continuously removing products from the stock.
     * The stock removal is synchronized using semaphores.
     */
    @Override
    public void run() {
        while(true){
            try {
                // Acquire a slot with a product in the buffer
                SemaphoreManager.full.acquire(1);
            } catch (InterruptedException e) {
                // Propagate any interruption as a runtime exception
                throw new RuntimeException(e);
            }
            try {
                // Acquire the mutex to ensure exclusive access to shared resources
                SemaphoreManager.mutex.acquire(1);
            } catch (InterruptedException e) {
                // Propagate any interruption as a runtime exception
                throw new RuntimeException(e);
            }
            // Print a notification about the removed product from the stock
            Console.print(Notifiers.CLIENT_REMOVE + " Product ID: " + getEntrepreneur().removeStock());
            // Release the mutex to allow other threads to access shared resources
            SemaphoreManager.mutex.release(1);
            // Signal that a slot in the buffer is now empty
            SemaphoreManager.empty.release(1);
            Console.print("Stock: " + getEntrepreneur().getStock().size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
