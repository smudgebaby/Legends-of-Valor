package com.company.mandh.map;

import com.company.GenerateRandom;

import java.util.ArrayList;

public class MandHMapFactory implements GameBoardFactory {
    @Override
    public GameBoard createGameBoard() {
        Marker common = new Marker("Common", ' ');
        CommonTileAction commonTileAction = new CommonTileAction();


        Marker inaccessible = new Marker("Inaccessible", '#');
        NullTileAction nullTileAction = new NullTileAction();

        Marker market = new Marker("Market", 'M');
        MarketTileAction marketAction = new MarketTileAction();

        Marker party = new Marker("Party", 'P');

        ArrayList<ArrayList<MandHTile>> returnBoard = new ArrayList<ArrayList<MandHTile>>();
        boolean partyPlaced = false;
        for (int i = 0; i < 3; i++) {
            returnBoard.add(new ArrayList<MandHTile>());
        }
        Position playerPosition = null;

        {
            int posY = 0;
            for (ArrayList<MandHTile> rowTile : returnBoard) {
                for (int posX = 0; posX < 3; posX++) {
                    int rng = GenerateRandom.getRandomNumberUsingNextInt(0, 11);
                    if (rng < 2) {
                        try {
                            rowTile.add(new MandHTile(((Marker) inaccessible.clone()), nullTileAction));
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    } else if (rng < 5) {
                        try {
                            rowTile.add(new MandHTile(((Marker) market.clone()), marketAction));
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    } else if (!partyPlaced) {
                        try {
                            MandHTile player = new MandHTile(((Marker) common.clone()),commonTileAction);
                            player.setCurrentMarker(party);
                            rowTile.add(player);
                            playerPosition = new Position(posX, posY);
                            partyPlaced = true;
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            rowTile.add(new MandHTile(((Marker) common.clone()),commonTileAction));
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                posY++;
            }
        }
        return new GameBoard(returnBoard, playerPosition);
    }
}