package com.ashishprataplldproblems.chessgame.pieces;

import com.ashishprataplldproblems.chessgame.Board;
import com.ashishprataplldproblems.chessgame.Cell;
import com.ashishprataplldproblems.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}