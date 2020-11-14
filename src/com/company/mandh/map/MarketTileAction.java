package com.company.mandh.map;

import com.company.mandh.DataFileMarketFactory;
import com.company.mandh.MAHParty;
import com.company.mandh.Marketplace;

public class MarketTileAction implements TileAction {
    private Marketplace marketplace;

    public MarketTileAction(){
        DataFileMarketFactory marketFactory = new DataFileMarketFactory();
        this.marketplace  = marketFactory.createMarket();
    }
    @Override
    public void doTileAction(MAHParty party) {
        marketplace.doPartyMarketVisit(party);
    }
}
