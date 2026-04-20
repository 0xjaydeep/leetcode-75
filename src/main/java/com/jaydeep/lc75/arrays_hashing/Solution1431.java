package com.jaydeep.lc75.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

public class Solution1431 {
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = candies[0];
            for(int c : candies) max = Math.max(max,c);
            List<Boolean> result = new ArrayList<>();
            for(int c : candies) {
                result.add(c + extraCandies >= max);
            }
            return result;
        }
    }
}
