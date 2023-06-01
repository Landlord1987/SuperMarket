package org.example.Interfaces;

import org.example.Classes.Actor;

import java.util.List;

/**
 * Интерфейс поведения магазина
 */
public interface iMarketBehaviour {
    void returnToMarket(iReturnOrder actor);
    /**
     * Метод, который подтверждает, что клиент пришел в магазин и инициализирует запись в очередь
     * @param actor клиент
     */
    void acceptToMarket(iActorBehaviour actor);

    /**
     * Метод, фиксирующий уход клиента из магазина и удалет клиентов из очереди
     * @param actors - список клиентов
     */
    void releaseFromMarket(List<Actor> actors);

    /**
     * Вызывает методы создания и получения заказа, после чего вызывает методу добавления клиента в список покинувших магазин
     */
    void update();
}
