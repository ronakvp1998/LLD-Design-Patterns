package com.LLD.LLDProblems.DesignTicTacToe;

import com.LLD.LLDProblems.DesignTicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import com.sun.tools.javac.util.Pair;


public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){

        // creating 2 players
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1",crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2",noughtsPiece);

        players.add(player1);
        players.add(player2);

        // Initialize Board
        gameBoard = new Board(3);

    }

    public String startGame() {

        boolean noWinner = true;
        while (noWinner){

            // take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // get the free space from the board
            gameBoard.printBoard();
            List<Pair<Integer,Integer>> freeSpaces = gameBoard. getFreeCells();

            // if no free space available then it will continue the while loop comes out of while loop and game will be tie
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            // If free space available
            // read the user input
            System.out.println("Player : " + playerTurn.name + " Enter row,column : ");
            Scanner inputScanner  = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn,playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                // player can not insert the piece into this cell, Player has to choose another cell
                System.out.println("Incorrect position chosen, Try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow,inputColumn, playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name;
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType){

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // need to check in row constant row
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                rowMatch = false;
            }
        }

        // nned to check in column constant column
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType){
                columnMatch = false;
            }
        }

        // need to check diagonal
        for(int i=0,j=0 ;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                diagonalMatch = false;
            }
        }

        // need to check anti-diagonal
        for(int i=0,j=gameBoard.size-1; i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
