// Import necessary classes and packages
import threads.Client;
import threads.Entrepreneur;
import threads.Factory;
import utilities.Console;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // Create lists to hold clients and client threads
        List<Client> clients = new ArrayList<>();
        List<Thread> clientThreads = new ArrayList<>();

        // Create a scanner to read user input
        Scanner sc = new Scanner(System.in);

        // Create instances of Entrepreneur and Factory
        Entrepreneur entrepreneur = new Entrepreneur();
        Factory factory = new Factory();

        // Prompt the user to enter the number of clients
        Console.print("Enter number of clients: ");
        int nClients = sc.nextInt();

        // Initialize clients and client threads
        for(int i = 0; i < nClients; i++){
            clients.add(new Client());
            Client client = clients.get(i);
            client.setEntrepreneur(entrepreneur);
            clientThreads.add(new Thread(client));
        }

        // Set up the relationship between Entrepreneur, Factory, and Clients
        factory.setEntrepreneur(entrepreneur);
        entrepreneur.setFactory(factory);


        // Create and start the Factory thread
        Thread factoryThread = new Thread(factory);
        entrepreneur.setFactoryThread(factoryThread);
        // Create and start the Entrepreneur thread
        Thread entrepreneurThread = new Thread(entrepreneur);
        // Start all the client threads
        for(Thread clientThread : clientThreads){
            clientThread.start();
        }
        entrepreneurThread.start();
        factoryThread.start();
        try {
            // Wait for the Entrepreneur thread to finish
            entrepreneurThread.join();

            // Wait for the Factory thread to finish
            factoryThread.join();

            // Wait for all client threads to finish
            for(Thread clientThread : clientThreads){
                clientThread.join();
            }
        } catch (InterruptedException e) {
            // Handle interruption exceptions
            e.printStackTrace();
        }
    }
}
