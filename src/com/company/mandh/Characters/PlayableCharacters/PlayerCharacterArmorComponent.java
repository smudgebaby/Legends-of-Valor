package com.company.mandh.Characters.PlayableCharacters;

import com.company.mandh.items.Armor;
import com.company.mandh.ItemNotInInventory;
import com.company.mandh.items.ArmorComponent;

/**
 * Implementation of the ArmorComponenet of the inventory for the player.
 * Uses the default logic in the com.company.mandh.items.Armor Component to assist in equiping com.company.mandh.items.Armor
 */

public class PlayerCharacterArmorComponent implements ArmorComponent {
    public void equipArmor(PlayerCharacter character) throws InvalidLevelException, IllegalArgumentException, ItemNotInInventory {
        Armor armor = selectArmor(character.getInventoryComponent());
        if(!character.is_Character_Level_sufficent_for_Item(armor)){
            throw new InvalidLevelException("Character not proper Level to use armor");
        }
        else{
            armor.equip(character);
        }
    }
}
