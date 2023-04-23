package org.example.lab7.compulsory;

import java.util.List;


public class ExplorationMap {
    private final Cell[][] matrix;
    private final int n;
    private final SharedMemory sharedMemory;


    public ExplorationMap(int n, SharedMemory sharedMemory) {
        this.n = n;
        this.sharedMemory = sharedMemory;
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }


    public int getN() {
        return n;
    }


    public synchronized boolean visit(int row, int col, Robot robot) {
        //verific sa nu iasa din matrice
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return false;
        }

        Cell cell = matrix[row][col];
        synchronized (cell) {
            //daca celula nu a fost vizitata extrage tokenii, ii adauga la celula si seteaza celula ca fiind vizitata
            if (!cell.isVisited()) {
                List<Token> tokens = sharedMemory.extractToken(n);
                cell.addTokens(tokens);
                cell.setVisited(true);
                System.out.println(robot.getName() + " a vizitat celula [" + row + ", " + col + "] si a extras " + n + " tokens: " + tokens);
                robot.addTokens(n);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(matrix[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private static class Cell {
        private boolean visited;
        private List<Token> tokens;

        public synchronized boolean isVisited() {
            //verifica daca o celula a fost sau nu vizitata
            return visited;
        }

        public synchronized void setVisited(boolean visited) {
            //seteaza o celula ca fiind vizitata
            this.visited = visited;
        }

        public synchronized void addTokens(List<Token> tokens) {
            //adauga tokeni
            this.tokens = tokens;
        }

        @Override
        public synchronized String toString() {
            if (visited) {
                return tokens.toString();
            } else {
                return "-";
            }
        }
    }
}