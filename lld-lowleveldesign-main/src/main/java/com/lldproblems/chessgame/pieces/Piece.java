package com.lldproblems.chessgame.pieces;

import com.lldproblems.chessgame.Board;
import com.lldproblems.chessgame.Cell;
import com.lldproblems.chessgame.Color;

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
