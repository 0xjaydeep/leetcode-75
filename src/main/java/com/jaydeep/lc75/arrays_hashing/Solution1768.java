package com.jaydeep.lc75.arrays_hashing;

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int m = word1.length();
        int n = word2.length();
        int len = Math.max(m, n);
        for (int i = 0; i < len; i++) {
            if (i < m) {
                res.append(word1.charAt(i));
            }
            if (i < n) {
                res.append(word2.charAt(i));
            }
        }

        return res.toString();
    }
}
