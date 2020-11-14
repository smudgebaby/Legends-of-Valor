package com.company.mandh;

import com.company.*;
import com.company.mandh.Characters.NPC.Mob;

import java.util.ArrayList;


/**
 * Simple factory for creating mobs groups of a proper level and size
 *
 * Is a simple factory becuase there is no interface
 *
 */
public class LevelBasedMobFactory {
    public static ArrayList<Mob> createMob(int level, int size){
        ArrayList<Mob> returnlist = new ArrayList<Mob>();
        MobDatabase allMobs = new MobDatabase();
        ArrayList<Mob> leveledMobs =  removeAllMobs(allMobs,level);
        for(int i =0; i < size; i++){
            Mob temp = selectMob(leveledMobs);
            returnlist.add(temp);
            leveledMobs.remove(temp);
        }

        return returnlist;
    }

    private static Mob selectMob(ArrayList<Mob> mobs){
        int index = GenerateRandom.getRandomNumberUsingNextInt(0,mobs.size());
        return mobs.get(index);
    }

    private static ArrayList<Mob> removeMobs(ArrayList<Mob> mobs, int level){
        ArrayList<Mob> returnlist = new ArrayList<>();
        for(Mob villain:mobs){
            if(villain.getLevel() <= level){
                returnlist.add(villain);
            }
        }
        return returnlist;
    }

    private static ArrayList<Mob> removeAllMobs(MobDatabase mobdb, int level){
        ArrayList<Mob> returnlist = removeMobs(mobdb.getDragonList(),level);
        returnlist.addAll(removeMobs(mobdb.getExoskeletonList(),level));
        returnlist.addAll(removeMobs(mobdb.getSpiritList(), level));
        return returnlist;
    }




}
