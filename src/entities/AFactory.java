package entities;
import api.entities.IFactory;
import threads.Entrepreneur;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AFactory implements IFactory {
    Entrepreneur entrepreneur;
    private boolean production = true;
    @Override
    public int produce() {
        return ThreadLocalRandom.current().nextInt(10000);
    }

    public Entrepreneur getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(Entrepreneur entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public boolean isProduction() {
        return production;
    }

    public void setProduction(boolean production) {
        this.production = production;
    }
}
