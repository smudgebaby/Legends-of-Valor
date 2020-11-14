package com.company.mandh.items;

import com.company.*;
import com.company.mandh.ItemNotInInventory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface with some Default functions to assist in displaying lists of Potions,grabbing lists of Potions from an
 * com.company.mandh.items.Item list and users selecting 1 Potions from a Potions list
 *
 */

public interface PotionComponent {
    default Potion selectPotion(ArrayList<Item> inventory) throws ItemNotInInventory {
        ArrayList<Potion> potionList = getAllPotionsInInventory(inventory);
        if (potionList.size() == 0){
            throw new ItemNotInInventory("No potions in inventory");
        }
        DisplayTerminalTable.displayTerminalTable(setup_Potion_Table_To_Display(potionList));
        int index = PInput.getIntegerBounded(new Scanner(System.in), 0, potionList.size() -1, "Select which com.company.mandh.items.Potion:");
        return potionList.get(index);
    }

    default ArrayList<Potion> getAllPotionsInInventory(ArrayList<Item> inventoryComponent){
        ArrayList<Potion> returnList = new ArrayList<Potion>();
        for(Item item: inventoryComponent){
            if(item instanceof Potion){
                returnList.add((Potion) item);
            }
        }
        return returnList;
    }

    default ArrayList<ArrayList<String>> setup_Potion_Table_To_Display(ArrayList<Potion> potionList){
        ArrayList<ArrayList<String>> potionDisplayList = DisplayTerminalTable.initializeTableArrayList(6);
        addPotionListHeaders(potionDisplayList);
        int j = 0;
        for(Potion potion: potionList) {
            String data = potion.getInfo();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            potionDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                potionDisplayList.get(i).add(rowReader.next());
            }
        }
        return potionDisplayList;
    }

    private void addPotionListHeaders(ArrayList<ArrayList<String>> potionDisplayTable){
        int i = 0;
        potionDisplayTable.get(i++).add("Index");

        potionDisplayTable.get(i++).add("Name");
        potionDisplayTable.get(i++).add("Cost");
        potionDisplayTable.get(i++).add("Required Level");
        potionDisplayTable.get(i++).add("Stats Affected");
        potionDisplayTable.get(i++).add("Increase on Affected Stats");
    }
}
