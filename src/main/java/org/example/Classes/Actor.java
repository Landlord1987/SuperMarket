package org.example.Classes;

/**
 * Абстрактный класс участника рынка
 */
public abstract class Actor {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected boolean isReturnOrder;

    public Actor(String name) {
        this.name = name;
    }
    abstract public String getName();
}