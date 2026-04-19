package com.jaydeep.lc75.arrays_hashing;

/**
 * LC 1929 - Concatenation of Array [Easy]
 * Pattern: Simulation
 * Time: O(n) | Space: O(n)
 */
public class Solution1929 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1929 sol = new Solution1929();
        int[] result = sol.getConcatenation(new int[]{1, 2, 1});
        System.out.println(java.util.Arrays.toString(result)); // [1,2,1,1,2,1]
    }
}
