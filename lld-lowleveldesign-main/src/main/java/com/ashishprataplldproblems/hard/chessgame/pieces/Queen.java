package com.ashishprataplldproblems.hard.chessgame.pieces;

import com.ashishprataplldproblems.hard.chessgame.Board;
import com.ashishprataplldproblems.hard.chessgame.Cell;
import com.ashishprataplldproblems.hard.chessgame.Color;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());
        return (rowDiff == colDiff) || (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}
