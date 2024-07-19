package TrickQuestons;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,2,4,9,8,7,6,5,3]
              [1,2,5,9,8,7,6,4,3]
              [1,2,5,3,4,6,7,8,9]

Output: [1,2,5,3,4,6,7,8,9]



*/

    /*
        TLDR:
            1. from right find a number where graph dips ---> meaning ths stric decreasing order breaks
            2. now again from right find the number that's bigger than that number
            3. Swap
            4. Now reverse pivot+1 (decreasing to increasing order)
    */

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int pivot = -1;
        while(i>0){
            if(nums[i]>nums[i-1]){
                pivot = i-1;
                break;
            }
        }
        if(pivot>=0){
            int end = nums.length-1;
            while(nums[end]<=nums[pivot]){
                end--;
            }
            swap(nums, pivot, end);
        }
        reverse(nums, pivot+1);
    }

    public static void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(end>start){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
