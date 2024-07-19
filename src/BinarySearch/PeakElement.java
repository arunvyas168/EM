package BinarySearch;

/*
    QUESTION: A peak element is an element that is strictly greater than its neighbors.
    Note: Element is always considered to be strictly greater than a neighbor that is outside the array.
    Example:
        Input: nums = [1,2,3,1]
        Output: 2 (index)
*/


/*
    SOLUTION:
        TLDR: Use Modified Binary search
                    if mid is not peak --> go to the side that has the larger value
                    Larger side is guaranteed to have a peak

        1. get mid
        2. make sure mid is not 0th by checking m>0 and also check if left of mid is larger
        3. make sure mid is not end by checking with len-1 and also check if right of  mid is larger
        4. if both side not larger--> then mid is peak
*/


public class PeakElement {

    //O(Log(n)) Solution using binary search
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid>0)&&(nums[mid]<nums[mid-1])){
                end = mid-1;
            }else if((mid<nums.length-1)&&(nums[mid]<nums[mid+1])){
                start = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //O(n) solution linear scan

    public int findPeakElementLinear(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int i=0;
        while(i<nums.length){
            if(i==nums.length-1){
                if(nums[i]>nums[i-1]){
                    return i;
                }
            }else if(nums[i]>nums[i+1]){
                if((i==0)||(nums[i]>nums[i-1])){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    //O(Log(n)) Recursive Binary Search
    public int findPeakElementRecursion(int[] nums) {
        return findPeakElementRecursionHelper(nums, 0, nums.length-1);
    }
    public int findPeakElementRecursionHelper(int[] nums, int start, int end){
        if(end==start) {
            return start;
        }
        int mid = start + (end-start)/2;
        if(nums[mid]<nums[mid+1]){
            return findPeakElementRecursionHelper(nums, mid+1, end);
        }else{
            return findPeakElementRecursionHelper(nums, start, mid);
        }
    }

}
