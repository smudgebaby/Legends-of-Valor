package com.company;

import java.util.ArrayList;

/**
 * Class for display tables of strings on the terminal
 */

public class DisplayTerminalTable {
    public static void displayTerminalTable(ArrayList<ArrayList<String>> table){
        for(int i =0; table.size() > i; i++) {
            int maxLength = getMaxStringlength(table.get(i));
            for (int j = 0; table.get(i).size() > j; j++) {
                while (table.get(i).get(j).length() < maxLength) {
                    table.get(i).set(j,table.get(i).get(j).concat(" "));
                }
            }
        }
        for(int j= 0; table.get(0).size()> j; j++){
            String c = "|";
            for(int i=0; table.size() > i; i++){
                c += table.get(i).get(j) + "\t" +"|";
            }
            System.out.println(c);
        }
    }

    private static int getMaxStringlength(ArrayList<String> s){
        int max_size=0;
        for(int i=0; s.size() > i ; i++){
            if(s.get(i).length() > max_size){
                max_size = s.get(i).length();
            }
        }
        return max_size;
    }

    public static ArrayList<ArrayList<String>> initializeTableArrayList(int x){
        ArrayList<ArrayList<String>> returnList = new ArrayList<>();
        for(int i = 0; i<x; i++) {
            returnList.add(new ArrayList<String>());
        }
        return returnList;
    }

}
