package com.company.mandh.map;

import com.company.mandh.MAHParty;

public class InaccessibleTileAction implements TileAction{
    @Override
    public void doTileAction(MAHParty party) {
        System.out.println("Cannot move on this tile!");
    }
}
