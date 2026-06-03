package com.ashishprataplldproblems.hard.chessgame.pieces;

import com.ashishprataplldproblems.hard.chessgame.Board;
import com.ashishprataplldproblems.hard.chessgame.Cell;
import com.ashishprataplldproblems.hard.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}