package com.company.mandh.map;

import java.util.ArrayList;

public class MoveRightCommand implements MoveCommand {
    @Override
    public Position getPositionToMoveToFromPositionOnBoard(Position position, ArrayList<ArrayList<MandHTile>> board) {
        int delta = position.getX() +1;
        if(delta > board.get(position.getY()).size()-1){
            delta = 0;
        }
        return new Position(delta, position.getY());
    }
}
