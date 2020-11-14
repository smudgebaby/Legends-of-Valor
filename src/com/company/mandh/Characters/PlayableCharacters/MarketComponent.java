package com.company.mandh.Characters.PlayableCharacters;

import java.util.ArrayList;

import com.company.mandh.items.*;

/**
 * A class to encapsulate the com.company.mandh.Characters.PlayableCharacters.PlayerCharacter's class interactions with the market
 */
public class MarketComponent {
    protected int money;

    public MarketComponent(int money) {
        this.money = money;
    }

    public void buy(ArrayList<Item> playerinventory, Item purchase) throws IllegalStateException {
        if(money >= purchase.getCost()){
            money -= purchase.getCost();
            playerinventory.add(purchase);
        }
        else{
            throw new IllegalStateException("Character does not have the money to purchase!");
        }


    }

    public void sell(ArrayList<Item> playerinventory , Item item) {
        money += item.getCost()/2;
        playerinventory.remove(item);
    }

}
