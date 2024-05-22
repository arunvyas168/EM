package Comparator;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
    QUESTION:
    Given an integer array nums and an integer k, return the k most frequent elements.
    Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
*/

/*
    SOLUTION:
        1. Add {value:count} in HashMap
        2. Use Priority Queue --> heap but sort by VALUES
        3. Make sure size is only K
        4. Copy that queue content to array  and return
*/

public class TopKFrequentElements {
    public static int[] getTopKFrequentElement(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if((!map.isEmpty())&&(map.containsKey(num))) {
                int count = map.get(num);
                map.put(num, ++count);
            }else{
                map.put(num,1);
            }
        }

        //PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int i =0;
        int[] result = new int[k];
        while(!pq.isEmpty()){
            HashMap.Entry<Integer, Integer> e = pq.poll();
            result[i] = e.getKey();
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] result = getTopKFrequentElement(input,k);
        for(int num : result){
            System.out.println(num);
        }
    }
}
