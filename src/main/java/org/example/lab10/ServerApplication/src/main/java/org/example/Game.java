package org.example.lab10.ServerApplication.src.main.java.org.example;

public class Game {
    private String gameName;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(String gameName, String player1Name) {
        this.gameName = gameName;
        this.board = new Board(15);
        this.player1 = new Player(player1Name);
        //this.player2 = new Player(player2Name);
        this.currentPlayer = player1;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        char symbol = currentPlayer == player1 ? 'X' : 'O';
        boolean isValidMove = board.makeMove(row, col, symbol);

        if (isValidMove) {
            System.out.println(currentPlayer.getPlayerName() + " made a move at (" + row + ", " + col + ")");
            board.printBoard();

            if (board.isWinningMove(row, col, symbol)) {
                System.out.println(currentPlayer.getPlayerName() + " wins!");
                return true;
            } else if (board.isBoardFull()) {
                System.out.println("The game ends in a draw.");
                return true;
            }

            currentPlayer = currentPlayer == player1 ? player2 : player1;
        } else {
            System.out.println("Invalid move. Please try again.");
        }

        return false;
    }

    public int addPlayer(String playerName) {
        if (player2 == null) {
            player2 = new Player(playerName);
            return 1;
        }
        return 0;
    }

}
