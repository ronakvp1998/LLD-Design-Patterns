package com.lldproblems.chessgame.pieces;

import com.lldproblems.chessgame.Board;
import com.lldproblems.chessgame.Cell;
import com.lldproblems.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}