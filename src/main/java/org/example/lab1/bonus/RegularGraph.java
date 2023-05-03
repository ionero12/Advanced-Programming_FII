package org.example.lab1.bonus;

import java.util.Scanner;

public class RegularGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the regular graph: ");
        int n = sc.nextInt();

        System.out.print("Enter the degree of each vertex in the regular graph: ");
        int degree = sc.nextInt();

        if (n * degree % 2 != 0 || degree >= n) {
            System.out.println("This graph is not possible.");
            return;
        }

        int[][] A = new int[n][n];
        int[] degrees = new int[n];
        int remainingDegree = 0;
        for (int i = 0; i < n; i++) {
            degrees[i] = degree;
            remainingDegree += degree;
        }
        remainingDegree /= 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (remainingDegree > 0 && degrees[i] > 0 && degrees[j] > 0) {
                    A[i][j] = 1;
                    A[j][i] = 1;
                    degrees[i]--;
                    degrees[j]--;
                    remainingDegree--;
                }
            }
        }

        System.out.println("\nThe adjacency matrix of the regular graph is:");
        printMatrix(A);
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

