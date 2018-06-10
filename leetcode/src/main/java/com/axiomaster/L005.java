package com.axiomaster;

public class L005 {
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }

        int len = s.length();
        if (len == 1) {
            return s;
        }

        int maxLen = 1, curLen = 1, sbegin = 0;
        for (int i = 0; i < len; i++) {
            // odd
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                curLen = right - left + 1;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    sbegin = left;
                }
                left--;
                right++;
            }

            //even
            left = i;
            right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                curLen = right - left + 1;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    sbegin = left;
                }
                left--;
                right++;
            }
        }
        String res = s.substring(sbegin, sbegin + maxLen);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L005().longestPalindrome("babad"));
    }
}
