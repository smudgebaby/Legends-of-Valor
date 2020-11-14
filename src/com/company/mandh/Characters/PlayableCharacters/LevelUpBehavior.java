package com.company.mandh.Characters.PlayableCharacters;

/**
 * A Strategy interface which is used to encapsulate level up behavoir
 * of the different Hero professions
 */

public interface LevelUpBehavior {
    double FAVORED_STAT_MULTIPLIER = 1.1;
    double NORMAL_STAT_MULTIPLIER = 1.05;

    void levelUp(PlayerCharacter character);
}
