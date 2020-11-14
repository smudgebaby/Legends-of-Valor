package com.company.mandh.map;

import java.util.ArrayList;

public class MoveUpCommand implements MoveCommand {
    @Override
    public Position getPositionToMoveToFromPositionOnBoard(Position position, ArrayList<ArrayList<MandHTile>> board) {
        int delta = position.getY() -1;
        if(delta <0 ){
            delta = board.size()-1;
        }
        return new Position(position.getX(), delta);
    }
}
