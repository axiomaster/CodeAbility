package com.axiomaster;

public class L807 {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;

        int[] H = new int[m];
        int[] V = new int[m];

        for (int i = 0; i < m; i++) {
            int max = grid[i][0];
            for (int j = 1; j < m; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            H[i] = max;
        }

        for (int j = 0; j < m; j++) {
            int max = grid[0][j];
            for (int i = 1; i < m; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            V[j] = max;
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result += (Math.min(H[i], V[j]) - grid[i][j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        maxIncreaseKeepingSkyline(A);
    }
}
