package M;

import java.util.HashMap;
/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/



/*
        TLDR:
            1. Just use hash map for count.
            2. post insert check if updated count is > n/2
*/
public class MajorityElementHash {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int targetValue  = (nums.length/2);
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num)>targetValue){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] input = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(input));
    }
}
