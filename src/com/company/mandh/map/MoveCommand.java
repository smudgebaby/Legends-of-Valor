package com.company.mandh.map;

import java.util.ArrayList;

public interface MoveCommand {
    Position getPositionToMoveToFromPositionOnBoard(Position position,ArrayList<ArrayList<MandHTile>> board);
}
