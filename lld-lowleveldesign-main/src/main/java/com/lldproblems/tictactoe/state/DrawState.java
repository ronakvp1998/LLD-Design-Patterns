package com.lldproblems.tictactoe.state;

import com.lldproblems.tictactoe.Game;
import com.lldproblems.tictactoe.exceptions.InvalidMoveException;
import com.lldproblems.tictactoe.models.Player;

public class DrawState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. It was a draw.");
    }
}
