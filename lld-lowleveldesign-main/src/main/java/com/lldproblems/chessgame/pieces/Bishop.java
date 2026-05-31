package com.lldproblems.chessgame.pieces;

import com.lldproblems.chessgame.Board;
import com.lldproblems.chessgame.Cell;
import com.lldproblems.chessgame.Color;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());
        return (rowDiff == colDiff);
    }
}
