package api.collection;

/**
 * The {@code Limiters} class defines constants representing limits for stock management.
 * It provides predefined values for minimum and maximum stock levels that can be utilized
 * in classes related to stock management within the application.
 */
public class Limiters {

    /**
     * Represents the minimum acceptable stock level.
     * If the stock falls below this limit, it may trigger certain actions such as
     * notifying the entrepreneur to resume production.
     */
    public static final int MINIMUM_STOCK = 1;

    /**
     * Represents the maximum capacity for the stock.
     * If the stock reaches or exceeds this limit, it may trigger actions such as
     * notifying the entrepreneur to pause production.
     */
    public static final int MAXIMUM_STOCK = 3;
}

