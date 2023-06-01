package org.example.Classes;

import org.example.Interfaces.iActorBehaviour;
import org.example.Interfaces.iReturnOrder;

/**
 * Класс, отражающий поведение Налоговика
 */
public class TaxService implements iActorBehaviour {

    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;

    /**
     * Конструктор класса клиента из налоговой
     */
    public TaxService() {
        this.name = "Tax audit";
    }

    /**
     * Метод получения имени клиента
     * @return имя клиента
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        isTakeOrder = pickUpOrder;
    }

    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }



}
