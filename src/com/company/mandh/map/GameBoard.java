package com.company.mandh.map;



import com.company.mandh.MAHParty;

import java.util.ArrayList;

public class GameBoard {
    private ArrayList<ArrayList<MandHTile>> board;
    private Position playerPosition;

    public GameBoard(ArrayList<ArrayList<MandHTile>> gameboard, Position playerPosition){
        this.board = gameboard;
        this.playerPosition =playerPosition;
    }

    public void movePlayer(MoveCommand moveCommand, MAHParty party){

        Position attempt = (moveCommand.getPositionToMoveToFromPositionOnBoard(playerPosition,board));

        MandHTile newPos = getTile(attempt);

        if(newPos.getCurrentMarker().getName() != "Inaccessible") {
            Marker player = removePlayerMarker();
            playerPosition = attempt;
            newPos.setCurrentMarker(player);
            newPos.getTileAction().doTileAction(party);
        }

    }



    private Marker removePlayerMarker(){
        MandHTile oldPos = getTile(playerPosition);
        Marker player = oldPos.getCurrentMarker();
        oldPos.revertToRootMarker();
        return player;
    }


    public MandHTile getTile(Position position){
        return board.get(position.getY()).get(position.getX());
    }




    @Override
    public String toString() {
        String gameBoard = "";
        for(ArrayList<MandHTile> tileRow: board){
            for(int i =0; i < tileRow.get(0).getDisplay().size(); i++) {
                for (MandHTile tile : tileRow) {
                    gameBoard += tile.getDisplay().get(i);
                }
                gameBoard += '\n';
            }
        }
        return gameBoard;
    }



    //Members
        //2d array of tiles

    //methods
        //constructor
        //to String
}
