package api.entities;

/**
 * The {@code IEntrepreneur} interface defines the contract for entities representing entrepreneurs
 * involved in stock management. Implementing classes are expected to provide concrete
 * implementations for methods related to adding, removing, and checking the status of stock.
 */
public interface IEntrepreneur {
    /**
     * Adds a specified quantity of product to the stock.
     *
     * @param product The quantity of the product to be added to the stock.
     */
    void addStock(int product);

    /**
     * Removes a certain amount of stock. The exact logic for removing stock may depend on
     * the implementation in the classes that implement this interface.
     */
    int removeStock();

    /**
     * Checks if the stock is currently empty.
     *
     * @return {@code true} if the stock is empty, {@code false} otherwise.
     */
    boolean isStockEmpty();

    /**
     * Checks if the stock has reached its maximum capacity.
     *
     * @return {@code true} if the stock is at its maximum capacity, {@code false} otherwise.
     */
    boolean isMaximumStock();

    /**
     * Checks if the stock is at its minimum acceptable level.
     *
     * @return {@code true} if the stock is at its minimum acceptable level, {@code false} otherwise.
     */
    boolean isMinimumStock();
}
