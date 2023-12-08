package utilities;

import api.ISemaphore;
import lombok.Getter;

/**
 * The {@code Semaphore} class implements the {@link ISemaphore} interface,
 * providing a basic synchronization mechanism with counting semaphores.
 */
public class Semaphore implements ISemaphore {

    /** The counter representing the number of available permits. */
    private int counter;

    public int getCounter() {
        return counter;
    }

    public Semaphore(int counter){
        this.counter = counter;
    }

    /**
     * Acquires a permit from this semaphore, blocking until one is available.
     * If no permits are available, the calling thread will be blocked until a permit is released.
     *
     * @throws InterruptedException if the current thread is interrupted while waiting
     *                              for a permit
     */
    @Override
    public synchronized void acquire(int x) throws InterruptedException {
        counter = counter - x;
        if (counter < 0) {
            wait();
        }
    }

    /**
     * Releases a permit, incrementing the counter. If there are waiting threads,
     * one of them is selected to be unblocked.
     */
    @Override
    public synchronized void release(int x) {
        counter = counter + x;
        if (counter <= 0) {
            notify();
        }
    }
}
