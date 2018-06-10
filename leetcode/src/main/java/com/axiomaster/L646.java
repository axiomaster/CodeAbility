package com.axiomaster;

import java.util.Arrays;
import java.util.Comparator;

public class L646 {
    public int findLongestChain(int[][] pairs) {
        int res = 0, end = Integer.MIN_VALUE;

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int[] pair : pairs) {
            if (pair[0] > end) {
                ++res;
                end = pair[1];
            }
        }

        return res;
    }
}
