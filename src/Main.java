import threads.Entrepreneur;
import threads.Factory;

public class Main {
    public static void main(String[] args){
        /* Create Entrepreneur Instance */
        Entrepreneur entrepreneur = new Entrepreneur();
        /* Create Factory Instance */
        Factory factory = new Factory();
        factory.setEntrepreneur(entrepreneur);
        entrepreneur.setFactory(factory);
        Thread factoryThread = new Thread(factory);
        factoryThread.start();
        Thread entrepreneurThread = new Thread(entrepreneur);
        entrepreneurThread.start();
        try {
            entrepreneurThread.join();
            factoryThread.join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
        }
    }
}
