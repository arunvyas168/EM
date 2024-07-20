package M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Target Sum can be anything == here its zero
*/

/*
        TLDR:
            1. Sort mainly to avoid duplicates
            2. In 1st for loop skip if number is repeated  ----> skip same number in same 1st position
            3. In 2nd while loop Skip if number is repeated --> skip same number in same 2nd position
        Note: Its mainly about skipping in 1st and 2nd position
        Note: define three sum inside while;
*/




public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        // Sorting is needed to avoid duplicates
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // can be any target Sum
        int targetSum = 0;

        // Note 1st for loop decides number is postion 1
        for(int i=0; i<nums.length; i++){
            // Skip is 1st number in Three sum is duplicate (since sorted this works)
            if((i>0)&&(nums[i]==nums[i-1])){
                continue;
            }

            // Two pointer approach
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                // define 3 sum inside while
                int threeSum = nums[i]+ nums[start] + nums[end];

                // if sum is small go forward
                if(threeSum<targetSum){
                    start++;
                }else if(threeSum>targetSum){       // if sum is big go forward
                    end--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    // Now we don't need to increase both as in next loop we ll automatically increase
                    start++;
                    // If next start is same as previous then it will give out same 3-set again. so increament till we find unique
                    while((nums[start]==nums[start-1])&&(start<end)){
                        start++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> output = threeSum(input);
        for (List<Integer> list : output) {
            for (Integer value : list) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
