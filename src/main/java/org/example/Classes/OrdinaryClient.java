package org.example.Classes;

import org.example.Interfaces.iActorBehaviour;
import org.example.Interfaces.iReturnOrder;

import java.util.List;

/**
 * Класс, отражающий поведение обычного клиента
 */
public class OrdinaryClient extends Actor implements iActorBehaviour, iReturnOrder {

    /**
     * Конструктор класса обычного клиента
     * @param name - имя клиента магазина
     */
    public OrdinaryClient(String name) {
        super(name);
    }

    /**
     * Метод получения имени клиента
     * @return имя клиента
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
