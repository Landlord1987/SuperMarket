package org.example.Interfaces;

import org.example.Classes.Actor;

import java.util.List;

public interface iReturnOrder extends iActorBehaviour{

    Actor getActor();

    boolean isReturnOrder();

    void setReternOrder(boolean isReturnOrder);
}
