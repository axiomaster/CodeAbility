package com.axiomaster;

import java.util.Arrays;

public class L787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int inf = 0x3f3f3f3f;
        int[] ds = new int[n];
        Arrays.fill(ds, inf);
        ds[src] = 0;

        int ans = ds[dst];
        for (int k = 0; k <= K; k++) {
            int[] nds = new int[n];
            Arrays.fill(nds, inf);
            for (int[] e : flights) {
                nds[e[1]] = Math.min(nds[e[1]], ds[e[0]] + e[2]);
            }
            ds = nds;
            ans = Math.min(ans, ds[dst]);
        }

        if (ans == inf) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        new L787().findCheapestPrice(3, flights, 0, 2, 1);
    }
}
