package com.ashishprataplldproblems.hard.chessgame;

public class ChessGameDemo {
    public static void run() {
        ChessGame chessGame = new ChessGame();
        chessGame.setPlayers("Alice", "Bob");
        chessGame.start();
    }

    // Add this entry point
    public static void main(String[] args) {
        run();
    }
}
