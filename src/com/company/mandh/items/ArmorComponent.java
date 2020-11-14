package com.company.mandh.items;

import com.company.*;
import com.company.mandh.ItemNotInInventory;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Interface with some Default functions to assist in displaying lists of com.company.mandh.items.Armor,grabbing lists of com.company.mandh.items.Armor from an
 * com.company.mandh.items.Item list and users selecting 1 com.company.mandh.items.Armor from a com.company.mandh.items.Armor list
 *
 */

public interface ArmorComponent {
    default Armor selectArmor(ArrayList<Item> inventory) throws ItemNotInInventory {
        ArrayList<Armor> armorList = getAllArmorsInInventory(inventory);
        if (armorList.size() == 0){
            throw new ItemNotInInventory("No armors in inventory");
        }
        DisplayTerminalTable.displayTerminalTable(setup_armor_Table_To_Display(armorList));
        int index = PInput.getIntegerBounded(new Scanner(System.in), 0, armorList.size() -1, "Select which Armor: ");
        return armorList.get(index);
    }

    default ArrayList<Armor> getAllArmorsInInventory(ArrayList<Item> inventoryComponent){
        ArrayList<Armor> returnList = new ArrayList<>();
        for(Item item: inventoryComponent){
            if(item instanceof Armor){
                returnList.add((Armor) item);
            }
        }
        return returnList;
    }

    default ArrayList<ArrayList<String>> setup_armor_Table_To_Display(ArrayList<Armor> armorArrayList){
        ArrayList<ArrayList<String>> armorDisplayList = DisplayTerminalTable.initializeTableArrayList(5);
        addArmorListHeaders(armorDisplayList);
        int j = 0;
        for(Armor armor: armorArrayList) {
            String data = armor.getInfo();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            armorDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                armorDisplayList.get(i).add(rowReader.next());
            }
        }
        return armorDisplayList;
    }

    private void addArmorListHeaders(ArrayList<ArrayList<String>> armorDisplayTable){
        int i = 0;
        armorDisplayTable.get(i++).add("Index");

        armorDisplayTable.get(i++).add("Name");
        armorDisplayTable.get(i++).add("Cost");
        armorDisplayTable.get(i++).add("Required Level");
        armorDisplayTable.get(i++).add("Damage Reduction");

    }
}
