package com.company.mandh.Characters.PlayableCharacters;

/**
 * Concrete implementation of the Levelup Strategy for the Warrior profession
 */


public class WarriorLevelUpBehavior implements LevelUpBehavior {
    @Override
    public void levelUp(PlayerCharacter character) {
        character.setStrength((int) (character.getStrength() * FAVORED_STAT_MULTIPLIER));
        character.setDexterity((int) (character.getDexterity() * NORMAL_STAT_MULTIPLIER));
        character.setAgility((int) (character.getAgility() * FAVORED_STAT_MULTIPLIER));
    }
}
