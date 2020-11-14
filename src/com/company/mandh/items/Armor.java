package com.company.mandh.items;

import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

/**
 * Implementation of the com.company.mandh.items.Armor item in the game. com.company.mandh.items.Armor is equipable but not usable.
 *
 */

public class Armor extends Item implements Equipable {
    protected int damageReduction;

    public Armor(String name,int cost,int requiredLevel,int damageReduction) {
        super(name,cost,requiredLevel);
        this.damageReduction = damageReduction;
    }

    public Armor(){
        throw new UnsupportedOperationException("No Default Constructor, Out of Time");
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    @Override
    public void equip(PlayerCharacter actor) {
        actor.getInventoryComponent().add(actor.getEquipedArmor());
        actor.setEquipedArmor(this);
    }

    public String getInfo(){
        return name +'\t'+ cost + '\t' +  requiredLevel + '\t' + damageReduction;
    }
}
