package org.example.lab10.compulsory.ServerApplication.src.main.java.org.example;

public class Board {
    private final int size = 15;
    private char[][] grid;

    public Board(int size) {
        this.grid = new char[size][size];
        initializeGrid();
    }

    public int getSize() {
        return size;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (isValidMove(row, col) && grid[row][col] == '-') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean isWinningMove(int row, int col, char symbol) {
        int count = 1;

        // Check horizontally
        count += countConsecutiveSymbols(row, col, symbol, 0, 1) + countConsecutiveSymbols(row, col, symbol, 0, -1);

        if (count >= 5) {
            return true;
        }

        count = 1;

        // Check vertically
        count += countConsecutiveSymbols(row, col, symbol, 1, 0) + countConsecutiveSymbols(row, col, symbol, -1, 0);

        if (count >= 5) {
            return true;
        }

        count = 1;

        // Check diagonally (top-left to bottom-right)
        count += countConsecutiveSymbols(row, col, symbol, 1, 1) + countConsecutiveSymbols(row, col, symbol, -1, -1);

        if (count >= 5) {
            return true;
        }

        count = 1;

        // Check diagonally (top-right to bottom-left)
        count += countConsecutiveSymbols(row, col, symbol, -1, 1) + countConsecutiveSymbols(row, col, symbol, 1, -1);

        return count >= 5;
    }

    private int countConsecutiveSymbols(int row, int col, char symbol, int rowIncrement, int colIncrement) {
        int count = 0;
        int newRow = row + rowIncrement;
        int newCol = col + colIncrement;

        while (isValidMove(newRow, newCol) && grid[newRow][newCol] == symbol) {
            count++;
            newRow += rowIncrement;
            newCol += colIncrement;
        }

        return count;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
