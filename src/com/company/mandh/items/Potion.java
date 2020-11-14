package com.company.mandh.items;

import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

import java.util.ArrayList;

/**
 * com.company.mandh.items.Potion class to implement all types of potions
 *
 * Stat name is used to hold all the names of the stats affected, could use a rename.
 *
 */

public class Potion extends Item implements Usable{
    protected ArrayList<String> statAffected;
    protected int increase;


    public Potion(String name, int cost, int requiredLevel, ArrayList<String> statAffected, int increase) {
        super(name, cost, requiredLevel);
        this.statAffected = statAffected;
        this.increase = increase;
    }

    @Override
    public void use(PlayerCharacter character) throws IllegalArgumentException {
        for(String stat : statAffected) {
            switch (stat) {
                case "Health":
                    character.setCurrentHP(character.getCurrentHP() + increase);
                    break;
                case "Mana":
                    character.setCurrentMana(character.getCurrentMana() + increase);
                    break;
                case "Strength":
                    character.setStrength(character.getStrength() + increase);
                    break;
                case "Dexterity":
                    character.setDexterity(character.getDexterity() + increase);
                    break;
                case "Agility":
                    character.setAgility(character.getAgility() + increase);
                    break;

                case "All":
                    character.setCurrentHP(character.getCurrentHP() + increase);
                    character.setCurrentMana(character.getCurrentMana() + increase);
                    character.setStrength(character.getStrength() + increase);
                    character.setDexterity(character.getDexterity() + increase);
                    character.setAgility(character.getAgility() + increase);
                    break;
                default:
                    throw new IllegalArgumentException("Stat type not found");
            }
        }
    }

    public String getInfo(){
        return name + '\t'+ cost +'\t' + requiredLevel + '\t' + statAffected + '\t' + increase;
    }




}
