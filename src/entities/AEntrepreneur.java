package entities;

import api.collection.Limiters;
import api.entities.IEntrepreneur;
import threads.Factory;

import java.util.ArrayList;
import java.util.List;

public abstract class AEntrepreneur implements IEntrepreneur {
    Factory factory;
    Thread factoryThread;
    private List<Integer> stock = new ArrayList<>();
    @Override
    public void addStock(int product) {
        stock.add(product);
    }

    @Override
    public int removeStock() {
         return stock.removeLast();
    }

    @Override
    public boolean isStockEmpty() {
        return stock.isEmpty();
    }

    @Override
    public boolean isMaximumStock() {
        return stock.size() >= Limiters.MAXIMUM_STOCK;
    }

    @Override
    public boolean isMinimumStock() {
        return stock.size() <= Limiters.MINIMUM_STOCK;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public void setFactoryThread(Thread factoryThread){
        this.factoryThread = factoryThread;
    }
    public Thread getFactoryThread(){
        return factoryThread;
    }

    public List<Integer> getStock() {
        return stock;
    }
}
