package org.example;

import org.example.Classes.*;
import org.example.Interfaces.iActorBehaviour;
import org.example.Interfaces.iReturnOrder;

public class Main {
    public static void main(String[] args) throws Exception {
        Market market = new Market();
        iActorBehaviour client1 = new OrdinaryClient("Boris");
        iActorBehaviour client2 = new OrdinaryClient("Dasha");
        iActorBehaviour client3 = new SpecialClient("Prezident", 1);
        iActorBehaviour client4 = new StockClient("Vika", 1);
        iActorBehaviour client5 = new StockClient("Sasha", 2);

        market.acceptToMarket(client1);
        market.acceptToMarket(client2);
        market.acceptToMarket(client3);
        market.acceptToMarket(new TaxService());
        market.acceptToMarket(client4);
        market.acceptToMarket(client5);

        market.update();

        market.returnToMarket((iReturnOrder) client1);

        market.update();
    }
}