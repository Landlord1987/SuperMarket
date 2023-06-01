package org.example.Interfaces;

import org.example.Classes.Actor;

public interface iQueueBehaviour {

    /**
     * Метод добавления клиента в список покинувших очередь и вывод информации в консоль
     */
    void releaseFromQueue();

    /**
     * Метод проверят делал ли клиент заказ, если нет то делает заказ. Информацию выводит в консоль
     */
    void takeOrder();

    /**
     * Метод добавления в очередь клиента
     * @param actor - клиент
     */
    void takeInQueue(iActorBehaviour actor);

    /**
     * Метод проверяет делал ли клиент и заказ, и в случае истины получает его. Информацию выводит в консоль
     */
    void giveOrder();
}
