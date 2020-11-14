package com.company.mandh.Characters.NPC;

import com.company.mandh.Characters.*;
import com.company.*;


public class Mob extends MandHCharacter {
    //members
        //permanent
            //has a breed
            //has a currentHP

    //methods
        //Constructor

        //combat
            //attack

    private String type;
    private int currentHP;

    private static final double AGILITY_DODGE_MULTIPLIER = 0.01;

    public Mob(String name, String type, int level, int strength, int dexterity, int agility) {
        super(name, level, strength, dexterity, agility);
        this.type = type;
        this.currentHP = level*getHpLevelMultiplier();
    }


    public String getType() {
        return type;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    @Override
    public void attack(ICombatComponent character) throws CharacterDeadException {
        if(!character.isDead()) {
            int damage = this.getStrength() ; //this one
            System.out.println(this.getName() + " attacks " + character.getName());
            character.handleAttack(damage);
        }
        else{
            throw new CharacterDeadException("Character is not alive, cannot Target!");
        }
    }

    @Override
    public void handleAttack(int damage) {
        if(!isDodged()){
           hit(calculateReducedDamage(damage));
        }
    }

    private boolean isDodged(){
        double dodgeChance = this.getAgility()* AGILITY_DODGE_MULTIPLIER;
        int roll = GenerateRandom.getRandomNumberUsingNextInt(0,101);
        if(roll < ((int) dodgeChance*100)){
            System.out.println(this.getName() + " dodged!");
            return true;
        }
        return false;
    }
    private int calculateReducedDamage(int damage){
        int reducedDamage = (int) (damage- this.getDexterity()*DEXTERITY_DEFENSE_MULTIPLIER);
        if (reducedDamage <= 0){
            System.out.println(this.getName() + " is unaffecetd! Use a stronger attack.");
            reducedDamage = 0;
        }
        return reducedDamage;
    }

    private void hit(int damage) {
        currentHP -= damage;
        System.out.println(this.getName() + " takes " + damage + " damage!");
        if(currentHP <= 0) {
            System.out.println(this.getName() + " is Defeated!");
            currentHP =0;
        }
    }

    @Override
    public boolean isDead() {
        if(this.currentHP <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public String getCombatInfo(){
        return name + '\t' + type + '\t' + level + '\t' + currentHP;
    }



}
