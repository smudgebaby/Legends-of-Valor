package com.company.mandh.map;

import java.util.ArrayList;

public class MoveLeftCommand implements MoveCommand{
    @Override
    public Position getPositionToMoveToFromPositionOnBoard(Position position, ArrayList<ArrayList<MandHTile>> board) {
        int delta = position.getX() -1;
        if(delta < 0){
            delta = board.get(position.getY()).size()-1;
        }
        return new Position(delta, position.getY());
    }
}
