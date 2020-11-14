package com.company.mandh;

import com.company.mandh.Characters.NPC.Mob;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Database for reading all the characters from the given text files
 */

public class MobDatabase {
    private ArrayList<Mob> dragonList;
    private ArrayList<Mob> exoskeletonList;
    private ArrayList<Mob> spiritList;

    public MobDatabase(){
        try {
            this.dragonList = readDragons(new File("src/Dragons.csv"));
            this.exoskeletonList = readExoskeletons(new File("src/Exoskeletons.csv"));
            this.spiritList = readSpirits(new File("src/Spirits.csv"));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public ArrayList<Mob> getDragonList() {
        return dragonList;
    }

    public ArrayList<Mob> getExoskeletonList() {
        return exoskeletonList;
    }

    public ArrayList<Mob> getSpiritList() {
        return spiritList;
    }

    private ArrayList<Mob> readDragons(File file) throws FileNotFoundException {
        ArrayList<Mob> returnList = new ArrayList<Mob>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readDragon(reader.nextLine()));
        }
        return returnList;
    }

    private Mob readDragon(String data) {
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name= name.stripTrailing();
        int level = rowReader.nextInt();
        int strength = rowReader.nextInt();
        int dexterity = rowReader.nextInt();
        int agility = rowReader.nextInt();

        return new Mob(name,"Dragon", level,strength,dexterity,agility);
    }


    private ArrayList<Mob> readExoskeletons(File file) throws FileNotFoundException {
        ArrayList<Mob> returnList = new ArrayList<Mob>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readExoskeleton(reader.nextLine()));
        }
        return returnList;
    }

    private Mob readExoskeleton(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name= name.stripTrailing();
        int level = rowReader.nextInt();
        int strength = rowReader.nextInt();
        int dexterity = rowReader.nextInt();
        int agility = rowReader.nextInt();
        return new Mob(name,"Exoskeleton", level,strength,dexterity,agility);
    }



    private ArrayList<Mob> readSpirits(File file) throws FileNotFoundException {
        ArrayList<Mob> returnList = new ArrayList<Mob>();
        Scanner reader = new Scanner(file);
        reader.nextLine();
        while (reader.hasNextLine()){
            returnList.add(readSpirit(reader.nextLine()));
        }
        return returnList;

    }
    private Mob readSpirit(String data){
        Scanner rowReader = new Scanner(data);
        rowReader.useDelimiter(",");
        String name = rowReader.next();
        name= name.stripTrailing();
        int level = rowReader.nextInt();
        int strength = rowReader.nextInt();
        int dexterity = rowReader.nextInt();
        int agility = rowReader.nextInt();
        return new Mob(name,"Exoskeleton", level,strength,dexterity,agility);
    }
}

