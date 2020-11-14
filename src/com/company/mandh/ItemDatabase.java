package com.company.mandh;

import com.company.mandh.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Database for reading all the items from the given text files
 */

public class ItemDatabase {
    private ArrayList<Armor> armorList;
    private ArrayList<Potion> potionsList;
    private ArrayList<Weapon> weaponsList;
    private ArrayList<Spell> spellList;

    public ItemDatabase(){
        try {
            this.armorList = readArmors(new File("src/Armor.csv"));
            this.potionsList = readPotions(new File("src/Potions.csv"));
            this.weaponsList = readWeapons(new File("src/Weapons.csv"));
            this.spellList = readSpells(new File("src/Spells.csv"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public ArrayList<Armor> getArmorList() {
        return armorList;
    }

    public ArrayList<Potion> getPotionsList() {
        return potionsList;
    }

    public ArrayList<Weapon> getWeaponsList() {
        return weaponsList;
    }

    public ArrayList<Spell> getSpellList() {
        return spellList;
    }

    private ArrayList<Spell> readSpells(File file) throws FileNotFoundException {
        ArrayList<Spell> returnList = new ArrayList<Spell>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readSpell(reader.nextLine()));
        }
        return returnList;
    }

    private Spell readSpell(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int cost = rowReader.nextInt();
        int requiredLevel = rowReader.nextInt();
        int damage = rowReader.nextInt();
        int manaCost = rowReader.nextInt();
        String spellType = rowReader.next();
        return new Spell(name,cost,requiredLevel,damage,manaCost,spellType);

    }
    private ArrayList<Potion> readPotions(File file) throws FileNotFoundException {
        ArrayList<Potion> returnList = new ArrayList<Potion>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readPotion(reader.nextLine()));
        }
        return returnList;
    }

    private Potion readPotion(String data) {
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int cost = rowReader.nextInt();
        int requiredLevel = rowReader.nextInt();
        int statincrease = rowReader.nextInt();
        String statsEffected =  rowReader.next();
        statsEffected = statsEffected.stripTrailing();
        ArrayList<String> statsEffectedList = read_Stats_Affected_List(statsEffected);


        return new Potion(name ,cost ,requiredLevel,statsEffectedList,statincrease);
    }

    private ArrayList<String> read_Stats_Affected_List(String data){
        ArrayList<String> returnList = new ArrayList<String>();
        Scanner statReader = new Scanner(data);
        statReader.useDelimiter("/");
        while(statReader.hasNext()){
            returnList.add(statReader.next());
        }
        return returnList;
    }


    private ArrayList<Armor> readArmors(File file) throws FileNotFoundException {
        ArrayList<Armor> returnList = new ArrayList<Armor>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readArmor(reader.nextLine()));
        }
        return returnList;
    }

    private Armor readArmor(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int cost = rowReader.nextInt();
        int requiredLevel = rowReader.nextInt();
        int damageReduction = rowReader.nextInt();
        return new Armor(name,cost,requiredLevel,damageReduction);
    }

    private Weapon readWeapon(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name = name.stripTrailing();
        int cost = rowReader.nextInt();
        int requiredLevel = rowReader.nextInt();
        int damage = rowReader.nextInt();
        int hands = rowReader.nextInt();
        return new Weapon(name,cost,requiredLevel,damage,hands);
    }

    private ArrayList<Weapon> readWeapons(File file) throws FileNotFoundException {
        ArrayList<Weapon> returnList = new ArrayList<Weapon>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readWeapon(reader.nextLine()));
        }
        return returnList;

    }
}
