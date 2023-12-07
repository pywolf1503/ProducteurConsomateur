package entities;

import api.collection.Limiters;
import api.entities.IEntrepreneur;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public abstract class AEntrepreneur implements IEntrepreneur {
    private final List<Integer> stock = new ArrayList<>();
    @Override
    public void addStock(int product) {
        stock.add(product);
    }

    @Override
    public void removeStock() {
        stock.removeFirst();
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
        return stock.size() <= Limiters.MAXIMUM_STOCK;
    }
}
