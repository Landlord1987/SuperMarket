package org.example.Classes;

import org.example.Interfaces.iActorBehaviour;
import org.example.Interfaces.iMarketBehaviour;
import org.example.Interfaces.iQueueBehaviour;
import org.example.Interfaces.iReturnOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Класс магазин, который реализует логику работы магазина
 */
public class Market implements iMarketBehaviour, iQueueBehaviour {

    private List<iActorBehaviour> queue;
    private List<iReturnOrder> returnQueue;

    Logger logger = Logger.getLogger("LogMarket");
    FileHandler fh;

    /**
     * Конструктор магазина, который добавляет посетителя в очередь в ArrayList
     */
    public Market() {

        try {
            fh = new FileHandler("D:\\Программирование\\OOP_Java\\Seminar2\\SuperMarket\\LogMarket.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("StartLogMarket");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.queue = new ArrayList<iActorBehaviour>();
        this.returnQueue = new ArrayList<iReturnOrder>();
    }

    @Override
    public void returnToMarket(iReturnOrder actor) {
        String act = actor.getActor().getName() + " клиент пришел в магазин что бы вернуть товар";
        System.out.println(act);
        logger.info(act);
        takeInQueueReturn(actor);
    }

    private void takeInQueueReturn(iReturnOrder actor) {
        this.returnQueue.add(actor);
        String act = actor.getActor().getName() + " клиент добавлен в очередь возврата товара";
        System.out.println(act);
        logger.info(act);
    }

    /**
     * Метод, который подтверждает, что клиент пришел в магазин и инициализирует запись в очередь
     *
     * @param actor - это клиент
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        if (actor instanceof StockClient){
            String act = actor.getActor().getName() + " клиент пришел за акционным товаром в магазин";
            System.out.println(act);
            logger.info(act);
        } else {
            String act = actor.getActor().getName() + " клиент пришел в магазин";
            System.out.println(act);
            logger.info(act);}
        takeInQueue(actor);
    }

    /**
     * Метод добавления в очередь клиента
     *
     * @param actor - это клиент
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        String act = actor.getActor().getName() + " клиент добавлен в очередь";
        System.out.println(act);
        logger.info(act);
    }

    /**
     * Метод, фиксирующий уход клиента из магазина и удалет клиентов из очереди
     *
     * @param actors - список клиентов
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            String act = actor.getName() + " клиент ушел из магазина";
            System.out.println(act);
            logger.info(act);
            queue.remove(actor);
        }

    }

    /**
     * Вызывает методы создания и получения заказа, после чего вызывает методу добавления клиента в список покинувших магазин
     */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
        returnOrder();
        releaseFromQueueReturn();
    }

    private void releaseFromQueueReturn() {
        List<Actor> releaseReturnActors = new ArrayList<>();
        for (iReturnOrder actor : returnQueue) {
            if (actor.isReturnOrder()) {
                releaseReturnActors.add(actor.getActor());
                String act = actor.getActor().getName() + " клиент, вернувший товар, ушел из очереди ";
                System.out.println(act);
                logger.info(act);
            }

        }
        releaseFromMarket(releaseReturnActors);
    }


    private void returnOrder() {
        for (iReturnOrder actor : returnQueue) {
            if (!actor.isReturnOrder()) {
                actor.setReternOrder(true);
                String act = actor.getActor().getName() + " клиент вернул товар ";
                System.out.println(act);
                logger.info(act);

            }
        }
    }

    /**
     * Метод проверяет делал ли клиент и заказ, и в случае истины получает его. Информацию выводит в консоль
     */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor instanceof StockClient)
            {
                if (((StockClient) actor).getIdActor() > 1){
                    String act = actor.getActor().getName() + " Аукционный товар закончился ";
                    System.out.println(act);
                    logger.info(act);
                    actor.setTakeOrder(false);
                }
                else {
                    actor.setTakeOrder(true);
                    String act = actor.getActor().getName() + " клиент получил акционный заказ ";
                    System.out.println(act);
                    logger.info(act);
                }
            } else {
                if (actor.isMakeOrder()) {
                    actor.setTakeOrder(true);
                    String act = actor.getActor().getName() + " клиент получил свой заказ ";
                    System.out.println(act);
                    logger.info(act);
                }
            }
        }

    }

    /**
     * Метод добавления клиента в список покинувших очередь и вывод информации в консоль
     */
    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                String act = actor.getActor().getName() + " клиент ушел из очереди ";
                System.out.println(act);
                logger.info(act);
            }

        }
        releaseFromMarket(releaseActors);
    }


    /**
     * Метод проверят делал ли клиент заказ, если нет то делает заказ. Информацию выводит в консоль
     */
    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                String act = actor.getActor().getName() + " клиент сделал заказ ";
                System.out.println(act);
                logger.info(act);

            }
        }

    }

}
