import threads.Client;
import threads.Entrepreneur;
import threads.Factory;
import utilities.Console;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Client> clients = new ArrayList<>();
        List<Thread> clientThreads = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Entrepreneur entrepreneur = new Entrepreneur();
        Factory factory = new Factory();
        Console.print("Enter number of clients: ");
        int nClients = sc.nextInt();
        for(int i = 0; i < nClients ; i++){
            clients.add(new Client());
            Client client = clients.getLast();
            client.setEntrepreneur(entrepreneur);
            clientThreads.add(new Thread(client));
        }
        factory.setEntrepreneur(entrepreneur);
        entrepreneur.setFactory(factory);
        Thread factoryThread = new Thread(factory);
        entrepreneur.setFactoryThread(factoryThread);
        factoryThread.start();
        Thread entrepreneurThread = new Thread(entrepreneur);
        entrepreneurThread.start();
        for(Thread clientThread : clientThreads){
            clientThread.start();
        }
        try {
            entrepreneurThread.join();
            factoryThread.join();
            for(Thread clientThread : clientThreads){
                clientThread.join();
            }
             } catch (InterruptedException e) {
                 e.printStackTrace();
        }
    }
}
