package entities;

import api.entities.IFactory;
import lombok.Getter;
import lombok.Setter;
import utilities.Entrepreneur;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AFactory implements IFactory {
    @Setter
    @Getter
    private Entrepreneur entrepreneur;
    @Setter
    @Getter
    private boolean production = false;
    @Override
    public int produce() {
        return ThreadLocalRandom.current().nextInt(10000);
    }
}
