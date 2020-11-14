package com.company.mandh.Characters.PlayableCharacters;

import com.company.*;
import com.company.mandh.Characters.*;
import com.company.mandh.items.*;

import java.util.ArrayList;

/**
 * com.company.mandh.Characters.PlayableCharacters.PlayerCharacter class for all the playerCharacter objects in the game.
 * This class interacts with com.company.mandh.items.Item, fight and Market classes;
 *
 * I wanted to encapsulate more features away from this class, but I ran out of time, but I'll list a few of my ideas:
 *
 * Create a actually CombatComponent Class
 * Use Strategy pattern to allow Combat Component class to be use by both Mob and this class with different behavior
 *
 * Encapsulate the inventory in another class which contains the already exsisting com.company.mandh.Characters.PlayableCharacters.MarketComponent;
 *
 *
 *
 */


public class PlayerCharacter extends MandHCharacter {

    private static final int EXP_LEVEL_MULTIPLIER = 10;
    private static final double AGILITY_DODGE_MULTIPLIER = 0.002;

    private static final double STRENGTH_ATTACK_MULTIPLIER = 0.25;



    private static final double FIGHT_REGAIN_MULTIPLIER = 1.1;

    private static final int FIGHT_WIN_COIN_MULTIPLIER = 100;

    private static final int FIGHT_WIN_EXP_ADDER = 2;

    private static final double MANA_INCREASE_MULTIPLIER = 1.1;

    private Profession profession;


    protected MarketComponent marketComponent;
    protected ArrayList<Item> inventoryComponent;

    private int currentMana;
    protected int mana;
    private int currentHP;
    private int currentEXP;

    private PlayerPotionComponent playerPotionComponent;
    private PlayerSpellComponent playerSpellComponent;
    private PlayerCharacterArmorComponent playerCharacterArmorComponent;
    private PlayerWeaponComponent playerWeaponComponent;



    protected Armor equipedArmor;
    protected Weapon equipedWeapon;

    public PlayerCharacter(String name, int level, int strength, int dexterity, int agility,
                           Profession profession, MarketComponent marketComponent, ArrayList<Item> inventoryComponent,
                           int mana, int currentEXP, Armor equipedArmor, Weapon equipedWeapon) {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        super(name, level, strength, dexterity, agility);
        this.profession = profession;
        this.marketComponent = marketComponent;
        this.inventoryComponent = inventoryComponent;
        this.currentMana = mana;
        this.mana = mana;
        this.currentHP = level* MandHCharacter.getHpLevelMultiplier();
        this.currentEXP = currentEXP;

        this.playerPotionComponent = new PlayerPotionComponent();
        this.playerSpellComponent = new PlayerSpellComponent();
        this.playerCharacterArmorComponent = new PlayerCharacterArmorComponent();
        this.playerWeaponComponent = new PlayerWeaponComponent();

        this.equipedArmor = equipedArmor;
        this.equipedWeapon = equipedWeapon;
    }



    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public ArrayList<Item> getInventoryComponent() {
        return inventoryComponent;
    }


    public Armor getEquipedArmor() {
        return equipedArmor;
    }

    public void setEquipedArmor(Armor equipedArmor) {
        this.equipedArmor = equipedArmor;
    }

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public void setEquipedWeapon(Weapon equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public boolean is_Character_Level_sufficent_for_Item(Item item){
        if(item.getRequiredLevel()> level){
            return false;
        }
        else{
            return true;
        }

    }



    public void attack(ICombatComponent character) throws CharacterDeadException {
        if(!character.isDead()) {
            int damage;
            if(equipedWeapon != null) {
                damage = (int) ((this.getStrength() + equipedWeapon.getDamage()) * STRENGTH_ATTACK_MULTIPLIER); //change
            }
            else {
                damage = (int) ((this.getStrength()) * STRENGTH_ATTACK_MULTIPLIER); //change
            }
            System.out.println(this.getName() + " attacks " + character.getName() + "...");
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
        double dodgeChance = this.getAgility()*AGILITY_DODGE_MULTIPLIER;
        int roll = GenerateRandom.getRandomNumberUsingNextInt(0,101);
        if(roll < ((int) dodgeChance*100)){
            System.out.println(this.getName() + " dodged!");
            return true;
        }
        return false;
    }
    private int calculateReducedDamage(int damage){
        int reducedDamage;
        if(equipedArmor == null){
            reducedDamage = (int) (damage - this.getDexterity()*DEXTERITY_DEFENSE_MULTIPLIER);
        }
        else {
            reducedDamage = (int) (damage - ((this.getDexterity() - equipedArmor.getDamageReduction())*DEXTERITY_DEFENSE_MULTIPLIER));
        }
        if (reducedDamage <= 0){
            System.out.println(this.getName() + " is unaffecetd!");
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



    public void usePotion(){
        playerPotionComponent.usePotion(this);
    }

    public void castSpell(MandHCharacter target) {
        playerSpellComponent.castSpell(this,target);
    }


    public void equipArmor(){
        playerCharacterArmorComponent.equipArmor(this);
    }


    public void equipWeapon(){
        playerWeaponComponent.equipWeapon(this);
    }

    public void dofightwin(int fightLevel){
        if(!isDead()){
            this.marketComponent.money += fightLevel*FIGHT_WIN_COIN_MULTIPLIER;
            this.currentEXP += FIGHT_WIN_EXP_ADDER;
            checkLevelUp();
        }
        else{
            dofightRecovery();
        }
    }

    public void dofightlost(){
        this.marketComponent.money /= 2;
        dofightRecovery();
    }

    private void dofightRecovery(){
        this.setCurrentHP((level* MandHCharacter.getHpLevelMultiplier())/2);
        this.setCurrentMana(mana/2);
    }

    public void doInFightRegain(){

        if((getCurrentHP() * FIGHT_REGAIN_MULTIPLIER) <= level*MandHCharacter.getHpLevelMultiplier()) {
            this.setCurrentHP((int) (getCurrentHP() * FIGHT_REGAIN_MULTIPLIER));
        }
        if(getCurrentMana()*FIGHT_REGAIN_MULTIPLIER <= mana) {
            this.setCurrentMana((int) (getCurrentMana() * FIGHT_REGAIN_MULTIPLIER));
        }
    }

    public void checkLevelUp() {
        while(currentEXP > level*EXP_LEVEL_MULTIPLIER){
            currentEXP -= level*EXP_LEVEL_MULTIPLIER;
            levelUp();
        }
    }

    private void levelUp(){
        this.mana *= MANA_INCREASE_MULTIPLIER;
        profession.levelUpBehavior.levelUp(this);
    }


    public MarketComponent getMarketComponent() {
        return marketComponent;
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

    private String inventoryString(){
            String returnString = "";
            for (Item item : inventoryComponent) {
                returnString += item.getName() + ",";
            }
            if(returnString == ""){
                returnString = "[]";
            }
            return returnString;

    }


    public String selectionString(){
        return name + '\t' + profession.type+  '\t'+ level + '\t'
                + currentMana + '/' + mana + '\t' + currentHP +'/' + level* MandHCharacter.getHpLevelMultiplier() +"\t" + currentEXP + '/' + level*EXP_LEVEL_MULTIPLIER
                + '\t' + strength + '\t' + dexterity + '\t' + agility
                + '\t' + marketComponent.money + '\t' + inventoryString();
    }


    public String characterInfo(){
        if(equipedArmor != null&& equipedWeapon != null) {
            return selectionString() + '\t' + equipedArmor.getInfo() + '\t' + equipedWeapon.getInfo();
        }
        else if(equipedArmor != null){
            return selectionString() + '\t' + equipedArmor.getInfo() + '\t' + "[]";
        }
        else if( equipedWeapon != null){
            return selectionString() + '\t' + "[]" + '\t' + equipedWeapon.getInfo();
        }
        else{
            return selectionString() + '\t' + "[]" + '\t' + "[]";
        }

    }

    @Override
    public String toString() {
        return name;
    }


}
