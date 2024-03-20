package Comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    static class customComparator implements Comparator<HashMap.Entry<Integer, Integer>>{
        @Override
        public int compare(HashMap.Entry<Integer, Integer> o1, HashMap.Entry<Integer, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }

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
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(new customComparator());
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
