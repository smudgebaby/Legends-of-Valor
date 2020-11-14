package com.company;

import com.company.mandh.Characters.ICombatComponent;
import com.company.mandh.GameLoop;


public class Main {

    public static void main(String[] args) {

        GameLoop.gameLoop2();


    }



    //GameLoop.gameLoop();

 /*
 Marker markerH = new Marker("Heros", 'H');
     Marker markerM = new Marker("Villains", 'M');

     NullTileAction nullTileAction = new NullTileAction();

     MandHTile tileH = new MandHTile(markerH,nullTileAction);
     MandHTile tileM = new MandHTile(markerM, nullTileAction);

     ArrayList<MandHTile> rowH = new ArrayList<MandHTile>();
     ArrayList<MandHTile> rowM = new ArrayList<MandHTile>();

     for(int i =0; i<3;i++){
         rowH.add(tileH);
         rowM.add(tileM);
     }
     ArrayList<MandHTile> rowHMH =new ArrayList<MandHTile>();
     rowHMH.add(tileH);
     rowHMH.add(tileM);
     rowHMH.add(tileH);

     ArrayList<ArrayList<MandHTile>> map = new ArrayList<ArrayList<MandHTile>>();

     map.add(rowH);
     map.add(rowM);
     map.add(rowHMH);

     GameBoard gameBoard = new GameBoard(map, null);
  */
}
