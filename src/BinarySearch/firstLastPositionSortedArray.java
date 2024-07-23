package BinarySearch;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*/

/*
        TLDR:
            1. Get pivot via binary search
            2. Find rane on both side for target
        Note: keep the boundary in mind
        Note: its left+1 and right-1;
*/
public class firstLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int pivot = binarySearch(nums, 0, nums.length-1, target);
        if (pivot==-1){
            return new int[] {-1, -1};
        }
        int left = pivot;
        int right = pivot;
        while((left>=0)&&(nums[left]==target)){
            left--;
        }
        while((right<nums.length)&&(nums[right]==target)){
            right++;
        }
        return new int[] {left+1, right-1};
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(nums[mid]==target){
            return mid;
        } else if(nums[mid]>target){
            return binarySearch(nums, start, mid-1, target);
        }else{
            return binarySearch(nums, mid+1, end, target);
        }
    }
}
