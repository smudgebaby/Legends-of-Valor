package com.company.mandh.Characters;

import com.company.mandh.Namable;

/**
 * Super Class of all characters in the game, currently only Heros and Monsters
 */
public abstract class MandHCharacter implements ICombatComponent , Namable {
    protected static final int HP_LEVEL_MULTIPLIER = 100;
    protected static final double DEXTERITY_DEFENSE_MULTIPLIER = 0.2;


        protected String name;
        protected int level;
        protected int strength;
        protected int dexterity;
        protected int agility;

    public MandHCharacter(String name, int level, int strength, int dexterity, int agility) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
    }



    public String getName(){
        return name;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getHpLevelMultiplier() {
        return HP_LEVEL_MULTIPLIER;
    }

    public static double getDexterityDefenseMultiplier() {
        return DEXTERITY_DEFENSE_MULTIPLIER;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}
