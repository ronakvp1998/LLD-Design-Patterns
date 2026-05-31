package com.ashishprataplldproblems.chessgame.pieces;

import com.ashishprataplldproblems.chessgame.Board;
import com.ashishprataplldproblems.chessgame.Cell;
import com.ashishprataplldproblems.chessgame.Color;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol()- from.getCol());
        return (rowDiff <= 1 && colDiff <= 1);
    }
}
