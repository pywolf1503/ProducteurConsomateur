package api;

/**
 * The {@code ISemaphore} interface represents a simple semaphore that can be used for
 * controlling access to a shared resource. It provides methods for acquiring and releasing
 * permits.
 */
public interface ISemaphore {

    /**
     * Acquires a permit from this semaphore, blocking until one is available, or the
     * thread is interrupted.
     *
     * @throws InterruptedException if the current thread is interrupted while waiting
     *                              for a permit
     */
    void acquire() throws InterruptedException;

    /**
     * Releases a permit, returning it to the semaphore. If there are waiting threads,
     * one of them is selected to be unblocked.
     */
    void release();
}
