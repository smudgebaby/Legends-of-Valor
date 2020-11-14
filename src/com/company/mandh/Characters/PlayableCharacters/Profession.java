package com.company.mandh.Characters.PlayableCharacters;

/**
 * com.company.mandh.Characters.PlayableCharacters.Profession class to encapsulate the behavior of all the professions of the player
 */

public class Profession{

    protected String type;

    protected LevelUpBehavior levelUpBehavior;

    public Profession(String type, LevelUpBehavior levelUpBehavior) {
        this.type = type;
        this.levelUpBehavior = levelUpBehavior;
    }




}


