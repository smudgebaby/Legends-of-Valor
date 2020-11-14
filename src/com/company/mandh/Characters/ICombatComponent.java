package com.company.mandh.Characters;

import com.company.mandh.Namable;

public interface ICombatComponent extends Namable {
    String getName();
    void attack(ICombatComponent character) throws CharacterDeadException;
    void handleAttack(int damage);
    boolean isDead();
}
