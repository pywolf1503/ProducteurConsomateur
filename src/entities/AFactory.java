package entities;

import api.entities.IFactory;
import utilities.Entrepreneur;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AFactory implements IFactory {
    Entrepreneur entrepreneur;
    @Override
    public int produce() {
        return ThreadLocalRandom.current().nextInt(10000);
    }
}
