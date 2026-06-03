package com.ashishprataplldproblems.medium.tictactoe.strategy;

import com.ashishprataplldproblems.medium.tictactoe.models.Board;
import com.ashishprataplldproblems.medium.tictactoe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
