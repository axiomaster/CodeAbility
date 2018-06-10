package com.axiomaster;

import java.util.HashSet;
import java.util.Set;

public class L764 {

    /**
     * 对于方阵N, 如果N为偶数，则dp[N] = max{dp[N-1]}, dp[N-1]代表从4个角开始的子矩阵
     * 如果N为基数， 则dp[N] = max{dp[N-1], 中心阶数}
     * 所以可以从左上角开始计算，计算完之后，将矩阵水平，垂直，翻转计算，得到4个矩阵对应的最大值
     *
     * 以下解法是拆解的更加零碎的方法
     * @param N
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        Set<Integer> mineset = new HashSet<Integer>();
        for (int[] mine : mines) {
            mineset.add(mine[0] * N + mine[1]);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            // 从左向右扫描，遇0置0， 遇1加1
            int count = 0;
            for (int j = 0; j < N; j++) {
                count = mineset.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = count;
            }

            // 从右向左扫描，遇0置0， 遇1加1
            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                count = mineset.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        // 从上向下
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                count = mineset.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }

            count = 0;
            for (int i = N - 1; i >= 0; i--) {
                count = mineset.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
