package com.ashishprataplldproblems.chessgame.pieces;

import com.ashishprataplldproblems.chessgame.Board;
import com.ashishprataplldproblems.chessgame.Cell;
import com.ashishprataplldproblems.chessgame.Color;

public abstract class Piece {
    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);

    public Color getColor() {
        return color;
    }
}
