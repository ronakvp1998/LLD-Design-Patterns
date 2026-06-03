package com.ashishprataplldproblems.medium.tictactoe.state;

import com.ashishprataplldproblems.medium.tictactoe.Game;
import com.ashishprataplldproblems.medium.tictactoe.models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
