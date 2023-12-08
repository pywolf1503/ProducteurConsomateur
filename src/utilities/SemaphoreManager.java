package utilities;

import api.collection.Limiters;

public class SemaphoreManager {
    // Mutex Semaphore
    public static Semaphore mutex = new Semaphore(1);
    // Empty Semaphore
    public static Semaphore empty = new Semaphore(Limiters.MAXIMUM_STOCK);
    // Full Semaphore
    public static Semaphore full = new Semaphore(0);
}
