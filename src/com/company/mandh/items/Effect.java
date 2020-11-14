package com.company.mandh.items;

import com.company.mandh.Characters.MandHCharacter;

/**
 * Strategy Interface for things that have side Effects
 */
public interface Effect {

    void sideEffect(MandHCharacter character);
}
