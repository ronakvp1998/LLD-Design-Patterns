package com.lldproblems.tictactoe.strategy;

import com.lldproblems.tictactoe.models.Board;
import com.lldproblems.tictactoe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
