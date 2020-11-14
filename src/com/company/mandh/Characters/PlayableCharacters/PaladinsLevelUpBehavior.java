package com.company.mandh.Characters.PlayableCharacters;

/**
 * Concrete implementation of the Levelup Strategy for the Paladin profession
 */

public class PaladinsLevelUpBehavior implements LevelUpBehavior {
    @Override
    public void levelUp(PlayerCharacter character) {
        character.setStrength((int) (character.getStrength() * FAVORED_STAT_MULTIPLIER));
        character.setDexterity((int) (character.getDexterity() * FAVORED_STAT_MULTIPLIER));
        character.setAgility((int) (character.getAgility() * NORMAL_STAT_MULTIPLIER));

    }
}
