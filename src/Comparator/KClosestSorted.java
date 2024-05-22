package Comparator;

import java.util.ArrayList;
import java.util.List;

/*
    QUESTION: Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
    Example 1:
        Input: arr = [1,2,3,4,5], k = 4, x = 3
        Output: [1,2,3,4]
*/


/*
    TLDR: Array is sorted so find the pivot --> NOTE pivot may not exist ---> binary search
        1.  Find the Pivot
        2.  If Pivot don't exist find closes with smaller value
        3.  Once pivot found now go either direction and find K smallest difference
      PS: corner cases are imp
*/



public class KClosestSorted {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if((arr.length==0)||(arr.length<k)){
            return null;
        }

        // call this function to get the index of x or closest to x
        int pivot = findPivot(arr, x, 0, arr.length-1);
        int left = pivot-1;
        int right = pivot+1;
        result.add(arr[pivot]);
        k--;
        while(k>0){
            if(left<0){
                result.add(arr[right]);
                right++;
                k--;
            }else if((right>arr.length-1) || (Math.abs(arr[left]-x)== Math.abs(arr[right]-x))){
                result.add(0,arr[left]);
                left--;
                k--;
            }else{
                if (Math.abs(arr[left]-x) < Math.abs(arr[right]-x)){
                    result.add(0,arr[left]);
                    left--;
                }else{
                    result.add(arr[right]);
                    right++;
                }
                k--;
            }
        }
        return result;
    }
    public static int findPivot(int[] arr, int pivot, int left, int right){
        while(right>=left){
            int mid = left+ (right-left)/2;
            if(arr[mid]==pivot){
                return mid;
            }
            if(arr[mid]>pivot){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        //Note: right has corssed left at this point so SWAP
        int temp = right;
        right = left;
        left = temp;


        if(left<0){    //if right has reached the begining
            return 0;
        }else if(right>arr.length-1){  //if left has reached the end
            return arr.length-1;
        }else{
            if ((pivot-arr[left])>(arr[right]-pivot)){  // if end side is closer return left(as left is in end)
                return right;
            }else{
                return left;       // both in case they are equal or even if the start side (return right)
            }
        }
    }

    public static void main(String[] args){
        int[] input = new int[]{1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        List<Integer> result = findClosestElements(input, k, x);
        for(int num : result){
            System.out.println(num);
        }
    }

}
