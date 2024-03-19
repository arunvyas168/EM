package Comparator;

import java.util.PriorityQueue;

public class KthLargest {
    /* priority queue default (natural order)
        Ascending order
        Logic is we keep adding to queue and remove top
        given its ascending and queue size is K
        we always end up removing the smallest from top which is K+1 largest
    */

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        if(!pq.isEmpty()) {
            return pq.peek();
        }else {
            return -1;
        }
    }

    public static void main (String[] args){
        int[] input = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(input, k));
    }

}
