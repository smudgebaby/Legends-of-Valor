package com.company.mandh;

import com.company.DisplayTerminalTable;
import com.company.mandh.Characters.NPC.Mob;
import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for holding all playerCharacters
 *
 */

public class MAHParty {
    private ArrayList<PlayerCharacter> party;

    public MAHParty(ArrayList<PlayerCharacter> party) {
        this.party = party;
    }

    public ArrayList<PlayerCharacter> getParty() {
        return party;
    }

    public void dofightwin(int fightLevel){
        for(PlayerCharacter character : party){
            character.dofightwin(fightLevel);
        }
    }

    public void dofightlost(){
        for(PlayerCharacter character : party){
            character.dofightlost();
        }
    }

    public void displayInfo(){
       DisplayTerminalTable.displayTerminalTable(setupCharacters());
    }

    private ArrayList<ArrayList<String>> setupCharacters(){
        ArrayList<ArrayList<String>> professionDisplayList = DisplayTerminalTable.initializeTableArrayList(14);
        addPlayerCharacterHeaders(professionDisplayList);
        int j = 0;
        for(PlayerCharacter character: party) {
            String data = character.characterInfo();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            professionDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                professionDisplayList.get(i).add(rowReader.next());
            }
        }
        return professionDisplayList;
    }

    private void addPlayerCharacterHeaders(ArrayList<ArrayList<String>> characterList){
        int i = 0;
        characterList.get(i++).add("Index");

        characterList.get(i++).add("Name");
        characterList.get(i++).add("Class");
        characterList.get(i++).add("Level");


        characterList.get(i++).add("Mana");
        characterList.get(i++).add("Health");
        characterList.get(i++).add("Experience");


        characterList.get(i++).add("Strength");
        characterList.get(i++).add("Dexterity");
        characterList.get(i++).add("Agility");

        characterList.get(i++).add("Money");
        characterList.get(i++).add("Inventory");

        characterList.get(i++).add("Equipped Armor");
        characterList.get(i++).add("Equipped Weapon");



    }

}
