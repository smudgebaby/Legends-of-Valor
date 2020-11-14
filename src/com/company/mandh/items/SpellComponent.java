package com.company.mandh.items;

import com.company.*;
import com.company.mandh.ItemNotInInventory;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Interface with some Default functions to assist in displaying lists of Spells,grabbing lists of Spells from an
 * com.company.mandh.items.Item list and users selecting 1 Spells from a Spells list
 *
 */

public interface SpellComponent {

    default Spell selectSpell(ArrayList<Item> inventory) throws ItemNotInInventory {
        ArrayList<Spell> spellList = getAllSpellsInInventory(inventory);
        if (spellList.size() == 0){
            throw new ItemNotInInventory("No spell in inventory");
        }
        DisplayTerminalTable.displayTerminalTable(setup_Spells_Table_To_Display(spellList));
        int index = PInput.getIntegerBounded(new Scanner(System.in), 0, spellList.size() -1, "Select which spell");
        return spellList.get(index);
    }

    default ArrayList<Spell> getAllSpellsInInventory(ArrayList<Item> inventoryComponent){
        ArrayList<Spell> returnList = new ArrayList<Spell>();
        for(Item item: inventoryComponent){
            if(item instanceof Spell){
                returnList.add((Spell) item);
            }
        }
        return returnList;
    }


    default ArrayList<ArrayList<String>> setup_Spells_Table_To_Display(ArrayList<Spell> spellList){
        ArrayList<ArrayList<String>> spellDisplayList = DisplayTerminalTable.initializeTableArrayList(7);
        addSpellListHeaders(spellDisplayList);
        int j = 0;
        for(Spell spell: spellList) {
            String data = spell.getInfo();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            spellDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                spellDisplayList.get(i).add(rowReader.next());
            }
        }
        return spellDisplayList;
    }


    private void addSpellListHeaders(ArrayList<ArrayList<String>> spellDisplayList) {
        int i = 0;
        spellDisplayList.get(i++).add("Index");

        spellDisplayList.get(i++).add("Name");
        spellDisplayList.get(i++).add("Type");
        spellDisplayList.get(i++).add("Cost");
        spellDisplayList.get(i++).add("Required Level");
        spellDisplayList.get(i++).add("Mana Cost");
        spellDisplayList.get(i++).add("Base Damage");

    }


}
