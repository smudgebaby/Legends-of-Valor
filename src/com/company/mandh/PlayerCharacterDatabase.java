package com.company.mandh;


import com.company.mandh.Characters.PlayableCharacters.*;
import com.company.mandh.items.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Database for reading all the characters from the given text files
 */

public class PlayerCharacterDatabase {
    private ArrayList<PlayerCharacter> paladinList;
    private ArrayList<PlayerCharacter> sorcererList;
    private ArrayList<PlayerCharacter> warriorsList;

    public PlayerCharacterDatabase(){
        try {
            this.paladinList = readPaladins(new File("src/Paladins.csv"));
            this.sorcererList = readSorcerers(new File("src/Sorcerers.csv"));
            this.warriorsList = readWarriors(new File("src/Warriors.csv"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public ArrayList<PlayerCharacter> getPaladinList() {
        return paladinList;
    }

    public ArrayList<PlayerCharacter> getSorcererList() {
        return sorcererList;
    }

    public ArrayList<PlayerCharacter> getWarriorsList() {
        return warriorsList;
    }



    private ArrayList<PlayerCharacter> readSorcerers(File file) throws FileNotFoundException {
        ArrayList<PlayerCharacter> returnList = new ArrayList<PlayerCharacter>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readSorcerer(reader.nextLine()));
        }
        return returnList;
    }

    private PlayerCharacter readSorcerer(String data) {
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int mana = rowReader.nextInt();
        int strength = rowReader.nextInt();
        int agility = rowReader.nextInt();
        int dexterity = rowReader.nextInt();
        int money = rowReader.nextInt();
        ArrayList<Item> inventory = new ArrayList<Item>();
        int experience = rowReader.nextInt();

        Profession temp = new Profession("Sorcerer", new SorcererLevelUpBehavior());
        return new PlayerCharacter(name, 1,strength,dexterity,agility,temp, new MarketComponent(money),new ArrayList<Item>(), mana, experience,null, null);
    }


    private ArrayList<PlayerCharacter> readPaladins(File file) throws FileNotFoundException {
        ArrayList<PlayerCharacter> returnList = new ArrayList<PlayerCharacter>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readPaladin(reader.nextLine()));
        }
        return returnList;
    }

    private PlayerCharacter readPaladin(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int mana = rowReader.nextInt();
        int strength = rowReader.nextInt();
        int dexterity = rowReader.nextInt();
        int agility = rowReader.nextInt();
        int money = rowReader.nextInt();
        ArrayList<Item> inventory = new ArrayList<Item>();
        int experience = rowReader.nextInt();

        Profession temp = new Profession("Paladin", new PaladinsLevelUpBehavior());
        return new PlayerCharacter(name, 1,strength,dexterity,agility,temp, new MarketComponent(money),new ArrayList<Item>(), mana, experience,null, null);
    }



    private ArrayList<PlayerCharacter> readWarriors(File file) throws FileNotFoundException {
        ArrayList<PlayerCharacter> returnList = new ArrayList<PlayerCharacter>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readWarrior(reader.nextLine()));
        }
        return returnList;

    }
    private PlayerCharacter readWarrior(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int mana = rowReader.nextInt();
        int strength = rowReader.nextInt();
        int dexterity = rowReader.nextInt();
        int agility = rowReader.nextInt();
        int money = rowReader.nextInt();
        ArrayList<Item> inventory = new ArrayList<Item>();
        int experience = rowReader.nextInt();

        Profession temp = new Profession("Warrior", new WarriorLevelUpBehavior());
        return new PlayerCharacter(name, 1,strength,dexterity,agility,temp, new MarketComponent(money),new ArrayList<Item>(), mana, experience,null, null);
    }
}
