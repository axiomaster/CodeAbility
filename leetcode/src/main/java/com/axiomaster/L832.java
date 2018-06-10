package com.axiomaster;

public class L832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        if (m == 0) {
            return A;
        }
        int n = A[0].length;
        if (n == 0) {
            return A;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][n - j - 1];
                A[i][n - j - 1] = tmp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
    }
}
