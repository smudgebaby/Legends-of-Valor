package com.company.mandh.Characters.PlayableCharacters;

import com.company.mandh.ItemNotInInventory;
import com.company.mandh.items.PotionComponent;
import com.company.mandh.items.*;

/**
 * Implementation of the com.company.mandh.items.PotionComponent of the inventory for the player.
 * Uses the default logic in the com.company.mandh.items.Potion Component to assist in using Potions
 */

public class PlayerPotionComponent implements PotionComponent {
    public void usePotion(PlayerCharacter character) throws InvalidLevelException, IllegalArgumentException, ItemNotInInventory {
        Potion potion = selectPotion(character.getInventoryComponent());
        if(!character.is_Character_Level_sufficent_for_Item(potion)){
            throw new InvalidLevelException("Character not proper Level to use potion");
        }
        else{
            potion.use(character);
        }
    }

}
