package com.company.mandh.map;

import java.util.ArrayList;

public class MoveDownCommand implements MoveCommand{
    @Override
    public Position getPositionToMoveToFromPositionOnBoard(Position position, ArrayList<ArrayList<MandHTile>> board) {
        int delta = position.getY() +1;
        if(delta > board.size()-1){
            delta = 0;
        }
        return new Position(position.getX(), delta);
    }

}
