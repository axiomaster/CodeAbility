package com.axiomaster;

import java.util.ArrayList;
import java.util.List;

public class L650 {

    // 太细致了，没必要，可以更暴力些

    public boolean isPrime(int n) {
        int sq = (int) Math.sqrt(n);
        for (int i = 2; i <= sq; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int minSteps(int n) {
        int[] dp = new int[n + 1];
        List<Integer> primes = new ArrayList<Integer>();

        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
                dp[i] = i;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0) {
                    int c = primes.get(j);
                    int s = i / c;
                    int res = Math.min(dp[c] + s, dp[s] + c);
                    if (res < min) {
                        min = res;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
