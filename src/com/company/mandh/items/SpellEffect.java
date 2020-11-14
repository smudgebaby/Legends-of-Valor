package com.company.mandh.items;

/**
 * Strategy sub-interface for com.company.mandh.items.Spell specific side effects.
 * holds the static constant for the spell side effect to apply to stats
 */

public interface SpellEffect extends Effect {
    double SPELL_STAT_REDUCTION_MULTIPLIER = 0.9;
}
