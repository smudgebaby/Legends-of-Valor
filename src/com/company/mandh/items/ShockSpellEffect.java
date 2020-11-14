package com.company.mandh.items;

import com.company.mandh.Characters.MandHCharacter;

/**
 * Concrete Strategy of the Shock type spell.
 * Renamed spell type from Lightning to Shock
 */

public class ShockSpellEffect implements SpellEffect{
    @Override
    public void sideEffect(MandHCharacter character) {
        character.setAgility((int) (character.getAgility() * SPELL_STAT_REDUCTION_MULTIPLIER));
    }
}
