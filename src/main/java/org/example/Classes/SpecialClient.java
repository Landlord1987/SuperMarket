package org.example.Classes;

import org.example.Interfaces.iActorBehaviour;
import org.example.Interfaces.iReturnOrder;

/**
 * Класс, отражающий поведение VIP клиента
 */
public class SpecialClient extends Actor implements iActorBehaviour, iReturnOrder {
    private int idVip;

    /**
     * Конструктор класса VIP клиента
     * @param name имя
     * @param id уникальный идентификатор
     */
    public SpecialClient(String name, int id) {
        super(name);
        this.idVip = id;
    }

    /**
     * Класс возвращающий idVip клиента
     * @return idVip клиента
     */
    public int getIdVip() {
        return idVip;
    }

    /**
     * Метод, возвращающий имя VIP клиента
     * @return - имя клиента магазина
     */
    @Override
    public String getName() {
        return super.name;
    }

    /**
     * Метод проверяет забрал ли клиент заказ
     * @return статус получения заказа
     */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    /**
     * Метод проверяет сделан ли клиентом заказа
     * @return статус заказа
     */
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /**
     * Метод, который делает доступным получение заказа, в случае, если клиент сделал заказ
     * @param makeOrder делает доступным получение товара клиентом
     */
    public void setTakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }

    /**
     * Метод, который выдает товар клиента в случае, если тот делал заказ
     * @param pickUpOrder фиксирует статус получения товара клиентом
     */
    public void setMakeOrder(boolean pickUpOrder) {
        super.isTakeOrder = pickUpOrder;
    }

    /**
     * Метод возвращает клиента
     * @return клиента
     */
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
}
