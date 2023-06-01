package org.example.Interfaces;

import org.example.Classes.Actor;

/**
 * Интерфейс поведения клиента
 */
public interface iActorBehaviour {
    /**
     * Метод изменения статуса создания заказа
     * @param makeOrder делает доступным забор заказа
     */
    void setMakeOrder(boolean makeOrder);

    /**
     * Метод изменения статуса получения заказа
     * @param pickUpOrder отражает статус получения заказа
     */
    void setTakeOrder(boolean pickUpOrder);

    /**
     * Метод проверки создан ли заказ
     * @return статус заказа
     */
    boolean isMakeOrder();

    /**
     * Метод проверки забора заказа
     * @return статус забран ли заказ
     */
    boolean isTakeOrder();

    /**
     * Метод возврата клиента
     * @return клиента
     */
    Actor getActor();
}
