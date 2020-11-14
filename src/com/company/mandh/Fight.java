package com.company.mandh;


import com.company.*;
import com.company.mandh.Characters.ICombatComponent;
import com.company.mandh.Characters.MandHCharacter;
import com.company.mandh.Characters.NPC.Mob;
import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Class for fight handling
 */

public class Fight {

    private MAHParty heros;
    private ArrayList<Mob> villains;

    public Fight(MAHParty heros) {
        this.heros = heros;
        this.villains = LevelBasedMobFactory.createMob(getPartyMaxLevel(),heros.getParty().size());
    }

    private static ArrayList<ArrayList<String>> setupVillains(ArrayList<Mob> mobList){
        ArrayList<ArrayList<String>> professionDisplayList = DisplayTerminalTable.initializeTableArrayList(5);
        addVillainsHeaders(professionDisplayList);
        int j = 0;
        for(Mob character: mobList) {
            String data = character.getCombatInfo();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            professionDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                professionDisplayList.get(i).add(rowReader.next());
            }
        }
        return professionDisplayList;
    }

    private static void addVillainsHeaders(ArrayList<ArrayList<String>> characterList){
        int i = 0;
        characterList.get(i++).add("Index");

        characterList.get(i++).add("Name");
        characterList.get(i++).add("Type");
        characterList.get(i++).add("Level");
        characterList.get(i++).add("Current HP");

    }


    public void handleFight(){

        boolean result = doFight();
        if(result) {
            heros.dofightwin(getVillainsLevels());
        }
        else{
            heros.dofightlost();
        }
    }

    private boolean doFight(){
        boolean turn = false;
        while(!isOver()){
            turn  = !turn;
            if(turn) {
                DisplayTerminalTable.displayTerminalTable(setupVillains(villains));
                System.out.println("");
                doPartyFightRound();
                System.out.println("");

            }
            else {
                doVillainsRound();
            }
        }
        return isVillainsDead();
    }

    private int getVillainsLevels(){
        int level = 0;
        for(Mob mob : villains){
            level += mob.getLevel();
        }
        return level;
    }


    private int getPartyMaxLevel() {
        int returnInt = 0;
        for (PlayerCharacter character : heros.getParty()) {
            int characterLevel = character.getLevel();
            if (characterLevel > returnInt) {
                returnInt = characterLevel;
            }

        }
        return returnInt;
    }

    private ICombatComponent SelectTarget(int priority, ArrayList<? extends ICombatComponent> targets) throws IllegalArgumentException, PartyDeadException{
        ICombatComponent test;
        try {
            test =targets.get(priority);
        }
        catch(IllegalArgumentException e1){
            try{
                priority =0;
                test = targets.get(priority);
            }
            catch(Exception e2){
                throw new IllegalArgumentException("Could not find a target at position 0");
            }
        }
        for(int i = 0; i < targets.size(); i++){
            if(priority> targets.size() -1){
                priority -=targets.size() -1;
            }
            if(!targets.get(priority + i).isDead()){
                return targets.get(priority + i) ;
            }
        }
        throw new PartyDeadException("Could not find a non-dead target");
    }


    private void doVillainsRound(){
        int i = 0;
        for (Mob mob :villains){
            if(isPartyDead()) {
                break;
            }
            else{
                doVillainAction(i++,mob);
            }

        }
    }

    private void doVillainAction(int position, Mob mob){
        mob.attack(SelectTarget(position, heros.getParty()));
    }

    private void doPlayerCharacterAction(int position, PlayerCharacter character){
        System.out.println(character.getName() + "\'s turn to move");
        boolean success = false;

        do {
            int action = PInput.getIntegerBounded(new Scanner(System.in), 0, 3, "Enter 0 to attack, 1 to cast a spell, 2 to use a potion, 3 to switch equipment, 4 to do nothing");
            switch (action) {
                case 0:
                    character.attack(SelectTarget(position, villains));
                    success = true;
                    break;
                case 1:
                    try{
                        character.castSpell((MandHCharacter) SelectTarget(position, villains));
                        success = true;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        success = false;
                    }
                    break;


                case 2:
                    try {
                        character.usePotion();
                        success = true;
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        success = false;
                    }
                    break;


                case 3:
                    int equipmentSelect = PInput.getIntegerBounded(new Scanner(System.in), 0,2,"Enter 0 to change com.company.mandh.items.Armor, 1 to change weapon, or any integer to cancel action");
                    switch(equipmentSelect) {
                        case 0:
                            try {
                                character.equipArmor();
                                success = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                                success = false;
                            }
                            break;
                        case 1:
                            try {
                                character.equipWeapon();
                                success = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                                success = false;
                            }
                            break;
                        default:
                            success = false;
                            break;
                    }
                    break;
                case 4:
                    success=true;
                    break;
                default:
                    success = false;
                    break;

            }
        }
        while(!success);
    }

    private void doPartyFightRound(){
        System.out.println("Heros turn");
        int i =0;
        for(PlayerCharacter character : heros.getParty()){
            if(!character.isDead()){
                doPlayerCharacterAction(i++,character);
                character.doInFightRegain();
            }
        }

    }

    private boolean isPartyDead(){
        for(PlayerCharacter character : heros.getParty()){
            if(!character.isDead()){
                return false;
            }
        }
        return true;
    }

    private boolean isVillainsDead(){
        for(Mob mob : villains){
            if(mob.getCurrentHP() > 0){
                return false;
            }
        }
        return true;
    }

    private boolean isOver(){
        return isPartyDead() || isVillainsDead();
    }

}
