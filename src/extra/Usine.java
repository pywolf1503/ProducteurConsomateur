package extra;

import java.util.concurrent.ThreadLocalRandom;

public class Usine implements Runnable{
    /**
     *
     * @return a random number between  0 - 4999
     */
    int produce(){
        return ThreadLocalRandom.current().nextInt(5000);
    }

    // Entrepreneur instance
    // Entrepreneur entrepreneur;
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        int produit = produce();
        // entrepreneur.addStock(produit);
        // System.out.println("Usine: made product and added stock: " + produit + " (" + entrepreneur.getStockSize() + ")");
    }
}
