package com.company.mandh.items;

import com.company.*;
import com.company.mandh.ItemNotInInventory;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Interface with some Default functions to assist in displaying lists of weapons,grabbing lists of weapons from an
 * com.company.mandh.items.Item list and users selecting 1 item from a weapon list
 *
 */
public interface WeaponComponent {
    default Weapon selectWeapon(ArrayList<Item> inventory) throws ItemNotInInventory {
        ArrayList<Weapon> weaponList = getAllWeaponsInInventory(inventory);
        if (weaponList.size() == 0){
            throw new ItemNotInInventory("No weapons in inventory");
        }
        DisplayTerminalTable.displayTerminalTable(setup_Weapon_Table_To_Display(weaponList));
        int index = PInput.getIntegerBounded(new Scanner(System.in), 0, weaponList.size() -1, "Select which com.company.mandh.items.Weapon:");
        return weaponList.get(index);
    }

    default ArrayList<Weapon> getAllWeaponsInInventory(ArrayList<Item> inventoryComponent){
        ArrayList<Weapon> returnList = new ArrayList<Weapon>();
        for(Item item: inventoryComponent){
            if(item instanceof Weapon){
                returnList.add((Weapon) item);
            }
        }
        return returnList;
    }

    default ArrayList<ArrayList<String>> setup_Weapon_Table_To_Display(ArrayList<Weapon> weaponList){
        ArrayList<ArrayList<String>> weaponDisplayList = DisplayTerminalTable.initializeTableArrayList(6);
        addWeaponListHeaders(weaponDisplayList);
        int j = 0;
        for(Weapon weapon: weaponList) {
            String data = weapon.getInfo();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            weaponDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                weaponDisplayList.get(i).add(rowReader.next());
            }
        }
        return weaponDisplayList;
    }

    private void addWeaponListHeaders(ArrayList<ArrayList<String>> weaponDisplayTable){
        int i = 0;
        weaponDisplayTable.get(i++).add("Index");

        weaponDisplayTable.get(i++).add("Name");
        weaponDisplayTable.get(i++).add("Cost");
        weaponDisplayTable.get(i++).add("Required Level");
        weaponDisplayTable.get(i++).add("Damage");
        weaponDisplayTable.get(i++).add("Required hands");
    }

}
