import java.util.Random;
import java.util.concurrent.Semaphore;

class Usine {
    private Semaphore productionSemaphore = new Semaphore(1);

    public int produireMarchandise() {
        try {
            productionSemaphore.acquire();
            // Simule la production de marchandises avec un nombre aléatoire
            Random random = new Random();
            int marchandise = random.nextInt(100);
            System.out.println("Usine produit : " + marchandise);
            return marchandise;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            productionSemaphore.release();
        }
    }
}

class Entrepot {
    private static final int NIVEAU_STOCK_MAX = 50;
    private static final int NIVEAU_STOCK_MIN = 10;

    private Semaphore stockSemaphore = new Semaphore(1);

    private int stock = 0;

    public void ajouterStock(int marchandise) {
        try {
            stockSemaphore.acquire();
            stock += marchandise;
            System.out.println("Entrepôt : Stock ajouté, total = " + stock);

            // Notifier l'usine si le stock atteint le niveau maximal
            if (stock >= NIVEAU_STOCK_MAX) {
                System.out.println("Entrepôt : Niveau maximal atteint, notifier l'usine pour arrêter la production.");
                // Ajoutez ici la logique pour notifier l'usine
            }

            // Notifier l'usine si le stock descend en dessous du niveau minimal
            if (stock < NIVEAU_STOCK_MIN) {
                System.out.println("Entrepôt : Niveau minimal atteint, notifier l'usine pour reprendre la production.");
                // Ajoutez ici la logique pour notifier l'usine
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stockSemaphore.release();
        }
    }

    public void retirerStock() {
        try {
            stockSemaphore.acquire();
            // Simule le retrait de marchandises
            if (stock > 0) {
                stock--;
                System.out.println("Client : Marchandise retirée, stock restant = " + stock);
            } else {
                System.out.println("Client : Attente, le stock est vide.");
                // Ajoutez ici la logique pour attendre si le stock est vide
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stockSemaphore.release();
        }
    }
}

class Client implements Runnable {
    private Entrepot entrepot;

    public Client(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    @Override
    public void run() {
        while (true) {
            entrepot.retirerStock();
            // Ajoutez ici la logique pour ajuster le rythme de la production en fonction du nombre de clients
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Usine usine = new Usine();
        Entrepot entrepot = new Entrepot();

        // Instancier une fois l'usine et l'entrepôt
        // Vous pouvez créer plusieurs instances de Client selon vos besoins
        Client client1 = new Client(entrepot);
        Client client2 = new Client(entrepot);

        Thread usineThread = new Thread(() -> {
            while (true) {
                int marchandise = usine.produireMarchandise();
                entrepot.ajouterStock(marchandise);
            }
        });

        Thread clientThread1 = new Thread(client1);
        Thread clientThread2 = new Thread(client2);


        usineThread.start();
        clientThread1.start();
        clientThread2.start();
    }
}
