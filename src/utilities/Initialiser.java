package utilities;

import api.IStarter;

/**
 * The {@code Initialiser} class implements the {@link IStarter} interface and provides
 * a simple initialization mechanism using a semaphore.
 */
public class Initialiser implements IStarter {

    /**
     * Initializes the starter by releasing a permit on the provided semaphore.
     *
     * @param s the semaphore to be used for initialization
     */
    @Override
    public void init(Semaphore s) {
        s.release();
    }
}
