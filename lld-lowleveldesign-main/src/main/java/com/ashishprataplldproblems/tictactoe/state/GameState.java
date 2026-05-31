package com.ashishprataplldproblems.tictactoe.state;

import com.ashishprataplldproblems.tictactoe.Game;
import com.ashishprataplldproblems.tictactoe.models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
