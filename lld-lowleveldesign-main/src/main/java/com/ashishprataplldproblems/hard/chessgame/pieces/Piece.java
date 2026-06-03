package com.ashishprataplldproblems.hard.chessgame.pieces;

import com.ashishprataplldproblems.hard.chessgame.Board;
import com.ashishprataplldproblems.hard.chessgame.Cell;
import com.ashishprataplldproblems.hard.chessgame.Color;

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
