package M;
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/



/*
        TLDR:
            We know that end of array is max psoitive
            We know beginig of array is max negative (or may be now)
            we have result array and we ll start filling from end
            We have 2 pointers and compare absolute value and start filling
*/

public class SquareSorted {

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int i = 0;
        int j = len-1;
        int index = len-1;
        while(i<=j){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                result[index]= nums[i]*nums[i];
                i++;
            }else{
                result[index]= nums[j]*nums[j];
                j--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{-4,-1,0,3,10};
        int[] result = sortedSquares(input);
        for (int num: result){
            System.out.println(num);
        }
    }
}
