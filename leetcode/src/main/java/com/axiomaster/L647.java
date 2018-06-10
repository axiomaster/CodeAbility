package com.axiomaster;

public class L647 {
    public int countSubstrings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            res = helper(s, i, i, res);
            res = helper(s, i, i + 1, res);
        }

        return res;
    }

    int helper(String s, int i, int j, int res) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
            ++res;
        }
        return res;
    }
}
