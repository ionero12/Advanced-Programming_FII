package org.example.lab1.bonus;

import java.util.Scanner;

public class CycleGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the cycle graph: ");
        int n = sc.nextInt();


        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            A[i][(i + 1) % n] = 1;
            A[(i + 1) % n][i] = 1;
        }
        printMatrix(A);


        int[][] Apowers = new int[n][n];
        Apowers = A;
        for (int i = 2; i <= n; i++) {
            Apowers = matrixMultiplication(Apowers, A);
            System.out.println("A" + i + ":");
            printMatrix(Apowers);
        }

        System.out.println("\nInterpretation of the result:");
        System.out.println("The powers of the adjacency matrix represent the number of paths of length i between any two vertices in the graph.");
        System.out.println("For example, A2 represents the number of paths of length 2 between any two vertices, A3 represents the number of paths of length 3, and so on.");
        System.out.println("Since the graph is a cycle, the number of paths of length i between any two vertices is equal to the number of vertices in the graph, if i is even,");
        System.out.println("and 0 if i is odd, except for the path of length n, which is equal to 1 between any two vertices.");
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
