package com.company.mandh.items;

import com.company.mandh.Characters.MandHCharacter;

/**
 * Concrete Strategy of the Ice type spell
 */

public class IceSpellEffect implements SpellEffect{

    @Override
    public void sideEffect(MandHCharacter character) {
        character.setStrength((int) (character.getStrength()* SPELL_STAT_REDUCTION_MULTIPLIER));
    }
}
