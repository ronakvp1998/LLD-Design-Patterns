package com.ashishprataplldproblems.medium.tictactoe.state;

import com.ashishprataplldproblems.medium.tictactoe.Game;
import com.ashishprataplldproblems.medium.tictactoe.exceptions.InvalidMoveException;
import com.ashishprataplldproblems.medium.tictactoe.models.Player;

public class DrawState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. It was a draw.");
    }
}
