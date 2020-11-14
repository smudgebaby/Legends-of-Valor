package com.company.mandh.map;

import com.company.GenerateRandom;
import com.company.mandh.Fight;
import com.company.mandh.MAHParty;

public class CommonTileAction implements TileAction {

    @Override
    public void doTileAction(MAHParty party) {
        int rng = GenerateRandom.getRandomNumberUsingNextInt(0,11);
        if(rng< 3) {
            Fight fight = new Fight(party);
            fight.handleFight();
        }
    }
}
