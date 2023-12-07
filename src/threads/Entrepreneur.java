package threads;

import api.collection.Notifiers;
import entities.AEntrepreneur;
import utilities.Console;

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
            // Check if the stock level is at its maximum
            if (isMaximumStock()) {
                // If so, set production to false and print a notification
                getFactory().setProduction(false);
                Console.print(Notifiers.MAXIMUM_STOCK);
            }

            // Check if the stock level is at its minimum
            if (isMinimumStock()) {
                // If so, set production to true and print a notification
                getFactory().setProduction(true);
                Console.print(Notifiers.MINIMUM_STOCK);
            }
        }
    }
}

