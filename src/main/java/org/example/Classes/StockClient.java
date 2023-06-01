package org.example.Classes;

import org.example.Interfaces.iActorBehaviour;
import org.example.Interfaces.iReturnOrder;

public class StockClient extends Actor implements iActorBehaviour, iReturnOrder {

    private int idActor;

    public StockClient(String name,int idActor) {
        super(name);
        this.idActor = idActor;
    }

    public int getIdActor() {
        return idActor;
    }

    @Override
    public void setMakeOrder(boolean pickUpOrder) {
        super.isTakeOrder = pickUpOrder;
    }

    @Override
    public void setTakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    @Override
    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

    @Override
    public void setReternOrder(boolean isReturnOrder) {
        super.isReturnOrder = isReturnOrder;
    }

    @Override
    public String getName() {
        return super.name;
    }
}
