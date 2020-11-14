package com.company.mandh;

import com.company.*;
import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;
import com.company.mandh.items.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for the handling of party Market visits.
 */

public class Marketplace implements WeaponComponent, ArmorComponent, PotionComponent, SpellComponent {
    //members
    private ArrayList<Item> inventory;


    public Marketplace(ArrayList<Item> inventory) {
        this.inventory = inventory;

    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void doPartyMarketVisit(MAHParty party) {
        for (PlayerCharacter character : party.getParty()) {
            System.out.println("Weapons:");
            DisplayTerminalTable.displayTerminalTable(setup_Weapon_Table_To_Display(getAllWeaponsInInventory(inventory)));
            System.out.println("com.company.mandh.items.Armor:");
            DisplayTerminalTable.displayTerminalTable(setup_armor_Table_To_Display(getAllArmorsInInventory(inventory)));
            System.out.println("Spells:");
            DisplayTerminalTable.displayTerminalTable(setup_Spells_Table_To_Display(getAllSpellsInInventory(inventory)));
            System.out.println("Potions:");
            DisplayTerminalTable.displayTerminalTable(setup_Potion_Table_To_Display(getAllPotionsInInventory(inventory)));
            doCharacterMarketVisit(character);
        }
    }


    private void doCharacterMarketVisit(PlayerCharacter character) {
        System.out.println(character.getName() + "'s turn to browse the market");
        boolean shopping = true;
        while (shopping) {
            int action = PInput.getIntegerBounded(new Scanner(System.in), 0, 2,
                    "Enter 0 to purchase an item, 1 to sell an com.company.mandh.items.Item, 2 to stop");
            int userInput = 0;
            switch (action) {
                case 0:
                    userInput = PInput.getIntegerBounded(new Scanner(System.in), 0, 4,
                            "Select which item type to purchase, 0 for com.company.mandh.items.Weapon, 1 for com.company.mandh.items.Armor, 2 for com.company.mandh.items.Spell, 3 for com.company.mandh.items.Potion, any other int to cancel");
                    switch (userInput) {
                        case 0:
                            character.getMarketComponent().buy(character.getInventoryComponent(), selectWeapon(this.inventory));
                            break;
                        case 1:
                            character.getMarketComponent().buy(character.getInventoryComponent(), selectArmor(this.inventory));
                            break;
                        case 2:
                            character.getMarketComponent().buy(character.getInventoryComponent(), selectSpell(this.inventory));
                            break;
                        case 3:
                            character.getMarketComponent().buy(character.getInventoryComponent(), selectPotion(this.inventory));
                        default:
                            break;

                    }
                    break;

                case 1:
                    userInput = PInput.getIntegerBounded(new Scanner(System.in), 0, 4,
                            "Select which item type to sell, 0 for com.company.mandh.items.Weapon, 1 for com.company.mandh.items.Armor, 2 for com.company.mandh.items.Spell, 3 for com.company.mandh.items.Potion, any other int to cancel");
                    ArrayList<Item> characterInventory = character.getInventoryComponent();
                    switch (userInput) {
                        case 0:
                            character.getMarketComponent().sell(characterInventory, selectWeapon(characterInventory));
                            break;
                        case 1:
                            character.getMarketComponent().sell(characterInventory, selectArmor(characterInventory));
                            break;
                        case 2:
                            character.getMarketComponent().sell(characterInventory, selectSpell(characterInventory));
                            break;
                        case 3:
                            character.getMarketComponent().sell(characterInventory, selectPotion(characterInventory));
                        default:
                            break;
                    }
                    break;
                case 2:
                    shopping = false;
                    break;
            }
        }
    }
}

    //methods

        //generate goods

        //buy
        //sell
        //get Inventory

