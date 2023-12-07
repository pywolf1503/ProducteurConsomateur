package threads;

import api.collection.Notifiers;
import entities.AClient;
import utilities.Console;

public class Client extends AClient implements Runnable{
    @Override
    public void run() {
        while(true){
            while(getEntrepreneur().isStockEmpty());
            Console.print(Notifiers.CLIENT_REMOVE + " Product ID: " + Integer.toString(getEntrepreneur().removeStock()));
        }
    }
}
