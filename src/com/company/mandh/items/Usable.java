package com.company.mandh.items;

import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

/**
 * com.company.mandh.items.Usable interface for Items that can be used on a playerCharacter
 *
 * com.company.mandh.items.Usable might need a rename since only potions are usable.
 *
 */
public interface Usable {
     void use(PlayerCharacter character);
}
