package entities;

import api.entities.IClient;


public abstract class AClient implements IClient {
    public AEntrepreneur getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(AEntrepreneur entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    private AEntrepreneur entrepreneur ;
    @Override
    public void toDo() {

    }
}
