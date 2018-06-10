package com.axiomaster;

public class L392 {
    public boolean isSubsequence(String s, String t) {
        if (null == s || s.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        for (j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == s.length()) {
                return true;
            }
        }

        return false;
    }
}
