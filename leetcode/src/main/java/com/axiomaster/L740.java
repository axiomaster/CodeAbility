package com.axiomaster;

public class L740 {
    public int deleteAndEarn(int[] nums) {
        //基数排序
        int[] sums = new int[10001];
        for (int num : nums) {
            sums[num] += num;
        }
        // 拿 or 跳过上一个数字
        int take = 0, skip = 0;
        for (int i = 0; i < 10001; i++) {
            int takei = skip + sums[i];
            int skipi = Math.max(skip, take);

            take = takei;
            skip = skipi;
        }

        return Math.max(skip, take);
    }
}
