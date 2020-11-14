package com.company.mandh.Characters.PlayableCharacters;

/**
 * Concrete implementation of the Levelup Strategy for the Sorcerer profession
 */


public class SorcererLevelUpBehavior implements LevelUpBehavior {
    @Override
    public void levelUp(PlayerCharacter character) {
        character.setStrength((int) (character.getStrength() * NORMAL_STAT_MULTIPLIER));
        character.setDexterity((int) (character.getDexterity() * FAVORED_STAT_MULTIPLIER));
        character.setAgility((int) (character.getAgility() * FAVORED_STAT_MULTIPLIER));
    }
}
