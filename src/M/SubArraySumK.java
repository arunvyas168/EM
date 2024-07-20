package M;

import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
*/




/*
        TLDR:
            1. Iterate
            2. Compute cumulative Sum
            3. Map.put(cumulativeSum, (number of times you seen that cumilativeSum));
            Map Store: how many times I have seen a cumulative sum before
            4. Count  = count + count inside map
            Note: map.containsKey(sum - k) ---> (cumulativeSum-target) will give if sum there previously in map

*/


public class SubArraySumK {
    public static  int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();

        // cumulativeSum is 0 and count is 1 --> covers base case --> mainly if (sum-k) --> 0
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            // check if maps have (sum-k) ---> looking for prefix sum
            if (map.containsKey(sum - k)){
                // count is coming from the fact on how many prefixSum has that value
                count += map.get(sum - k);
            }
            // Add the cumulativeSum to map. but if already there increase count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]){
        int[] input = new int[]{1,1,1,1,1,1};
        int k = 3;
        System.out.println(subarraySum(input, k));
    }
}
