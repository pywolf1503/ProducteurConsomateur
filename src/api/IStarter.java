package api;

import utilities.Semaphore;

/**
 * The {@code IStarter} interface represents an entity that can be initialized
 * with a semaphore, providing a method to perform the initialization.
 */
public interface IStarter {

    /**
     * Initializes this starter with the provided semaphore.
     *
     * @param s the semaphore to be used for initialization
     */
    void init(Semaphore s);
}
