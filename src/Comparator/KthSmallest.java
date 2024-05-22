package Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    /* priority queue Comparator.reverseOrder (reverse order)
        Descending order
        Logic is we keep adding to queue and remove top
        given its descending and queue size is K
        we always end up removing the largest from top which is K+1 smallest
    */

    public static int findKthSmallest(int [] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        if(!pq.isEmpty()){
            return pq.peek();
        }else{
            return -1;
        }
    }

    public static void main (String[] args){
        int[] input = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthSmallest(input, k));
    }
}
