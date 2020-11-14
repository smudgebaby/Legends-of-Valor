package com.company.mandh.items;

import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

/**
 * Implementation of the com.company.mandh.items.Weapon item in the game. com.company.mandh.items.Weapon is equipable but not usable.
 *
 * Weapons are not usable because thier affect can depend on the wielder, and not just the target
 * possible rework of the usable interface could pass in additional functionality to support this.
 *
 */

public class Weapon extends Item implements Equipable{

    protected int damage;
    protected int hands;

    public Weapon(String name, int cost, int requiredLevel, int damage, int hands){
        super(name,cost,requiredLevel);
        this.damage = damage;
        this.hands = hands;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void equip(PlayerCharacter actor) {
        actor.getInventoryComponent().add(actor.getEquipedWeapon());
        actor.setEquipedWeapon(this);
    }


    public String getInfo(){
        return name + '\t'+ cost + '\t' + requiredLevel + '\t' + damage + '\t' + hands;
    }
}
