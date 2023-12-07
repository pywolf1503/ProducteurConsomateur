package entities;

import api.entities.IClient;
import lombok.Getter;
import lombok.Setter;

public abstract class AClient implements IClient {
    @Setter
    private AEntrepreneur entrepreneur ;
    @Override
    public void toDo() {

    }
}
