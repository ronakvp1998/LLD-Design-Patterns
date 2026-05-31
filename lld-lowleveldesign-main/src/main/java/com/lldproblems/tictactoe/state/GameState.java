package com.lldproblems.tictactoe.state;

import com.lldproblems.tictactoe.Game;
import com.lldproblems.tictactoe.models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
