package com.company.mandh;


import com.company.*;
import com.company.mandh.Characters.PlayableCharacters.PlayerCharacter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Factory for building com.company.mandh.MAHParty from the the start of the game. I used this pattern becuase it required
 * alot of logic to complete with use of the datafiles.
 *
 */

public class PlayerPartyStarterFactory {

    public MAHParty createParty(){
        PlayerCharacterDatabase pcdb = new PlayerCharacterDatabase();
        displayCharacters(pcdb);
        Scanner scan= new Scanner(System.in);
        ArrayList<PlayerCharacter> returnlist = new ArrayList<PlayerCharacter>();
        boolean buildingParty = true;
        do {

            int x = PInput.getIntegerBounded(scan, 0, 3, "Enter which class you would like the new member to be: 0 for Paladin, 1 for Sorcerer and 2 for Warrior, 3 to begin adventure.");
            int y = -1;
            switch (x) {
                case 0:
                    y = PInput.getIntegerBounded(scan, 0, pcdb.getPaladinList().size() - 1, "Enter which paladin to join your party:");
                    returnlist.add(pcdb.getPaladinList().get(y));
                    break;
                case 1:
                    y = PInput.getIntegerBounded(scan, 0, pcdb.getSorcererList().size() - 1, "Enter which Sorcerer to join your party:");
                    returnlist.add(pcdb.getSorcererList().get(y));
                    break;
                case 2:
                    y = PInput.getIntegerBounded(scan, 0, pcdb.getWarriorsList().size() - 1, "Enter which Warrior to join your party:");
                    returnlist.add(pcdb.getWarriorsList().get(y));
                    break;
                case 3:
                    if(returnlist.size() != 0) {
                        buildingParty = false;
                    }
                    else{
                        System.out.println("Must have atleast 1 party member to play!");
                    }
                    break;
            }
            if(returnlist.size() == 3){
                buildingParty = false;
            }
        }while(buildingParty);

        return new MAHParty(returnlist);
    }

    private static void displayCharacters(PlayerCharacterDatabase pcdb){
        displayPaladins(pcdb);
        displaySorcerers(pcdb);
        displayWarriors(pcdb);
    }

    private static void displayPaladins(PlayerCharacterDatabase pcdb){
        ArrayList<PlayerCharacter> paladinList = pcdb.getPaladinList();
        System.out.println("Paladins:");
        ArrayList<ArrayList<String>>  displayPaladins = setupCharacters(paladinList);
        DisplayTerminalTable.displayTerminalTable(displayPaladins);
        System.out.println("");
    }

    private static void displaySorcerers(PlayerCharacterDatabase pcdb){
        ArrayList<PlayerCharacter> sorcererList = pcdb.getSorcererList();
        System.out.println("Sorcerers:");
        ArrayList<ArrayList<String>>  displaySorcerer = setupCharacters(sorcererList);
        DisplayTerminalTable.displayTerminalTable(displaySorcerer);
        System.out.println("");
    }

    private static void displayWarriors(PlayerCharacterDatabase pcdb){
        ArrayList<PlayerCharacter> warriorsList = pcdb.getWarriorsList();
        System.out.println("Warriors:");
        ArrayList<ArrayList<String>>  displayWarriors = setupCharacters(warriorsList);
        DisplayTerminalTable.displayTerminalTable(displayWarriors);
        System.out.println("");
    }

    private static ArrayList<ArrayList<String>> setupCharacters(ArrayList<PlayerCharacter> professionList){
        ArrayList<ArrayList<String>> professionDisplayList = DisplayTerminalTable.initializeTableArrayList(12);
        addPlayerCharacterHeaders(professionDisplayList);
        int j = 0;
        for(PlayerCharacter character: professionList) {
            String data = character.selectionString();
            Scanner rowReader = new Scanner(data);
            rowReader.useDelimiter("\t");
            professionDisplayList.get(0).add(Integer.toString(j++));
            for (int i = 1; rowReader.hasNextLine(); i++) {
                professionDisplayList.get(i).add(rowReader.next());
            }
        }
        return professionDisplayList;
    }

    private static void addPlayerCharacterHeaders(ArrayList<ArrayList<String>> characterList){
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


    }

}
