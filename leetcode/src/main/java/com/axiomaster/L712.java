package com.axiomaster;

import static java.lang.Math.max;

// 最长公共子序列
public class L712 {
    public int minimumDeleteSum(String s1, String s2) {
        String res = "";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int sum = 0;

        for (int i = 0; i < s1.length(); i++) {
            sum += (int) s1.charAt(i);

            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + (int) s1.charAt(i);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        for (int j = 0; j < s2.length(); j++) {
            sum += (int) s2.charAt(j);
        }

        return sum - 2 * dp[s1.length()][s2.length()];
    }
}
