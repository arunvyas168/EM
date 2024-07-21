package M;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
*/


/*
        SOLUTION:
            TLDR: Go from reverse ---> decreasing order --> keep filling up
            1. have fill pointer in the end
            2. have pointer for each array where values end
            3. Traverse and if you see larger value add to fill pointer and reduce fill
            4. Traverse till either of array is reached to end
            5.
           NOTE: --- make sure to traverse remaining of array into the fill -- if any

*/

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int fill = m+n-1;
        int nums1end = m-1;
        int nums2end = n-1;
        //Start from reverse
        // have a pointer that will be used to fill
        //have 2 end pointers to keep tack of max betwen array
        // trick is to keep finsding max and start filling from end
        while((nums1end>=0)&&(nums2end>=0)){
            if(nums1[nums1end]<nums2[nums2end]){
                nums1[fill] = nums2[nums2end];
                fill--;
                nums2end--;
            }else{
                nums1[fill] = nums1[nums1end];
                fill--;
                nums1end--;
            }
        }

        // important don't forget to fill if anything left over from end2 or nums2
        while(nums2end>=0){
            nums1[fill] = nums2[nums2end];
            fill--;
            nums2end--;
        }
    }
}
