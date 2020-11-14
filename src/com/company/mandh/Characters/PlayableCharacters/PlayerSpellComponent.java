package com.company.mandh.Characters.PlayableCharacters;

import com.company.mandh.items.*;
import com.company.mandh.Characters.*;

/**
 * Implementation of the spellCastComponent of the inventory for the player.
 * Uses the default logic in the spellComponent to assist in casting Spells
 */

public class PlayerSpellComponent implements SpellComponent {
    private static final double DEXTERITY_SPELL_MULTIPLIER = 0.0001;
    public void castSpell(PlayerCharacter character, MandHCharacter target) throws CharacterDeadException, InvalidLevelException {
        if(!target.isDead()) {
            Spell spell = selectSpell(character.getInventoryComponent());
            if(!character.is_Character_Level_sufficent_for_Item(spell)){
                throw new InvalidLevelException("Character not proper Level to use spell!");
            }
            else {
                int damage = (int) ((character.getDexterity()*DEXTERITY_SPELL_MULTIPLIER *spell.getDamage())); //change
                System.out.println(character.getName() + " casts " + target.getName());
                target.handleAttack(damage);
                spell.doSideEffect(target);
            }
        }
        else{
            throw new CharacterDeadException("Character is not alive, cannot Target!");
        }
    }
}
