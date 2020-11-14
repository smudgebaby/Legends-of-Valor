package com.company.mandh.items;

import com.company.mandh.Characters.MandHCharacter;

/**
 * Concrete Strategy of the fire type spell
 */

public class FireSpellEffect implements SpellEffect{
    @Override
    public void sideEffect(MandHCharacter character) {
        character.setDexterity((int) (character.getDexterity()* SPELL_STAT_REDUCTION_MULTIPLIER));
    }
}
