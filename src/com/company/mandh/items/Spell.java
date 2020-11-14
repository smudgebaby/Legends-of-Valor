package com.company.mandh.items;

import com.company.mandh.Characters.MandHCharacter;

/**
 * com.company.mandh.items.Spell item class to implement the all the games spells.
 *
 * No sub Classes need as the Strategy pattern is employeed to encapsulate the different sideEffect logic of each spell type
 *
 *
 */

public class Spell extends Item {
    protected String spellType;
    protected int damage;
    protected int manaCost;
    protected SpellEffect effectBehavior;


    public Spell(String name,int cost,int requiredLevel,int damage,int manaCost, String spellType) throws IllegalArgumentException{
        super(name,cost,requiredLevel);
        this.damage= damage;
        this.manaCost = manaCost;
        this.spellType = spellType;
        if(spellType.equals("Ice")) {
            this.effectBehavior = new IceSpellEffect();
        }
        else if(spellType.equals("Fire")){
            this.effectBehavior = new FireSpellEffect();
        }
        else if(spellType.equals("Shock")){
            this.effectBehavior = new ShockSpellEffect();
        }
        else{
            throw new IllegalArgumentException("Spelltype not defined!");
        }
    }

    public void doSideEffect(MandHCharacter character) {
        this.effectBehavior.sideEffect(character);
    }

    public String getInfo(){
        return name + '\t' + spellType + '\t' + cost + '\t' + requiredLevel + '\t' + manaCost + '\t' + damage;
    }

    public int getDamage() {
        return damage;
    }
}
