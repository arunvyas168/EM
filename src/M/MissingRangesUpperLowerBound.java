package M;

/*
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.

Example 1:
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]
Explanation: The ranges are:
[2,2]
[4,49]
[51,74]
[76,99]
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
        TLDR:
            1. Handle no elements case
            2. Handle lower to 1st element case
            3. middle range --> traverse till nums.length-1
            4. last elemnet case
*/

public class MissingRangesUpperLowerBound {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        //List<Integer> sublist = new List<Integer>();
        List<List<Integer>> finallist = new ArrayList<>();

        //if array has no elements
        if(nums.length==0){
            finallist.add(Arrays.asList(lower, upper));
            return finallist;
        }

        //Between lower bound and array first element
        if(lower < nums[0]){
            finallist.add(Arrays.asList(lower, nums[0]-1));
        }


        //for the middle range
        for( int i=0 ;i < nums.length-1;i++){

            if(nums[i+1] - nums[i] <=1){
                continue;
            }
            finallist.add(Arrays.asList(nums[i]+1, nums[i+1]-1));
        }

        //Between array last element and upper bound
        if(upper > nums[nums.length-1]){
            finallist.add(Arrays.asList(nums[nums.length-1]+1, upper));
        }

        return finallist;
    }
}
