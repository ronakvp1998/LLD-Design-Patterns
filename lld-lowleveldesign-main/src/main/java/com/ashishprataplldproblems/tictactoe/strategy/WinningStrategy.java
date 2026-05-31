package com.ashishprataplldproblems.tictactoe.strategy;

import com.ashishprataplldproblems.tictactoe.models.Board;
import com.ashishprataplldproblems.tictactoe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
