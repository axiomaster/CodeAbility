package com.axiomaster;

public class L486 {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else {
            return Math.max(nums[start] - helper(nums, start + 1, end), nums[end] - helper(nums, start, end - 1));
        }
    }
}
