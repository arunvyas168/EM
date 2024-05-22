package BinarySearch;

public class binarySearch {

    // Binary search linear
    public int search(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        while(end>=start){
            int mid = start + (end-start)/2;
            if(nums[mid]== target){
                return mid;
            }
            if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public int searchRecur(int[] nums, int target){

        return searchHelper(nums, 0, nums.length-1, target);
    }
    public int searchHelper(int[] nums, int start, int end, int target){
        if(end<start){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(nums[mid]==target) {
            return mid;
        }else if(nums[mid]<target){
            return searchHelper(nums, mid+1, end, target);
        }else{
            return searchHelper(nums, start, mid-1, target);
        }
    }


}
