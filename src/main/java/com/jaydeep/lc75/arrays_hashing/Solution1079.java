package com.jaydeep.lc75.arrays_hashing;

public class Solution1079 {
    class Solution1 {
        public String gcdOfStrings(String str1, String str2) {
            // Get the GCD of two Strings
            int gcdVal = gcd(str1.length(), str2.length());
            // GCD Candidate
            String result = str1.substring(0, gcdVal);

            if(isDivisible(str1, result) && isDivisible(str2, result)) return result;
            return "";

        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        private boolean isDivisible(String str, String result) {
            int chunks = str.length() / result.length();
            for(int i = 0; i < chunks; i++) {
                String chunk = str.substring(i * result.length(), (i + 1) * result.length()) ;
                if(!chunk.equals(result)) return false;

            }
            return true;
        }
    }

    class Solution2 {
        public String gcdOfStrings(String str1, String str2) {
            int gcdVal = gcd(str1.length(), str2.length());
            String result = str1.substring(0, gcdVal);
            if ((str1 + str2).equals(str2 + str1))
                return result;
            return "";

        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

    }
}
