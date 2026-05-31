package com.ashishprataplldproblems.tictactoe.state;

import com.ashishprataplldproblems.tictactoe.Game;
import com.ashishprataplldproblems.tictactoe.exceptions.InvalidMoveException;
import com.ashishprataplldproblems.tictactoe.models.Player;

public class WinnerState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. " + game.getWinner().getName() + " has won.");
    }
}
