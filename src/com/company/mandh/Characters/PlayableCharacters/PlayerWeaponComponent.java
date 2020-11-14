package com.company.mandh.Characters.PlayableCharacters;


import com.company.mandh.items.*;
import com.company.mandh.Characters.*;
import com.company.mandh.*;

/**
 * Implementation of the weaponComponent of the inventory for the player.
 * Uses the default logic in the com.company.mandh.items.Weapon Component to assist in equiping weapons
 */

public class PlayerWeaponComponent implements WeaponComponent {
    public void equipWeapon(PlayerCharacter character) throws InvalidLevelException, IllegalArgumentException, ItemNotInInventory {
        Weapon weapon = selectWeapon(character.getInventoryComponent());
        if(!character.is_Character_Level_sufficent_for_Item(weapon)){
            throw new InvalidLevelException("Character not proper Level to use weapon");
        }
        else{
            weapon.equip(character);
        }
    }
}
