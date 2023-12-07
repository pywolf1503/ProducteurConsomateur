package api.collection;

/**
 * The {@code Notifiers} class contains static final String constants
 * representing different notifications related to stock management.
 */
public class Notifiers {

    /**
     * Notification: Entrepreneur added stock.
     */
    public static final String STOCK_ADDED = "Entrepreneur: Added Stock";

    /**
     * Notification: Stock has reached its maximum; Factory stops production.
     */
    public static final String MAXIMUM_STOCK = "Entrepreneur: Maximum stock, Factory stops production.";

    /**
     * Notification: Stock has reached its minimum; Factory starts production.
     */
    public static final String MINIMUM_STOCK = "Entrepreneur: Minimum stock, Factory starts production";

    /**
     * Notification: Client removed stock.
     */
    public static final String CLIENT_REMOVE = "Client: Removed stock.";

    /**
     * Notification: Client has empty stock, waiting for reproduction.
     */
    public static final String CLIENT_WAIT = "Client: Empty Stock, Waiting for reproduction.";

    /**
     * Notification: Factory has produced stock.
     */
    public static final String FACTORY_PRODUCE = "Factory: Produced.";
}
