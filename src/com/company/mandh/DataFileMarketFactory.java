package com.company.mandh;

import java.util.ArrayList;

import com.company.mandh.items.*;

/**
 * Concrete Factory for market creation. Creates market based on items from the text files
 */

public class DataFileMarketFactory implements MarketFactory {


    public Marketplace createMarket() {
        ItemDatabase itdb = new ItemDatabase();
        ArrayList<Item> inventory = new ArrayList<Item>();

        combindLists(inventory,itdb.getArmorList());
        combindLists(inventory,itdb.getPotionsList());
        combindLists(inventory,itdb.getWeaponsList());
        combindLists(inventory, itdb.getSpellList());
        return new Marketplace(inventory);
    }

    private static void combindLists(ArrayList<Item> itemList, ArrayList<? extends Item> adder){
        for(Item i: adder){
            itemList.add(i);
        }

    }
}
