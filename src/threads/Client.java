package threads;

import api.collection.Notifiers;
import entities.AClient;
import utilities.Console;
import utilities.SemaphoreManager;

public class Client extends AClient implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                SemaphoreManager.full.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                SemaphoreManager.mutex.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Console.print(Notifiers.CLIENT_REMOVE + " Product ID: " + getEntrepreneur().removeStock());
            SemaphoreManager.mutex.release();
            SemaphoreManager.empty.release();
        }
    }
}
