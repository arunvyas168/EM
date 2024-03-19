package Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KNN {

    static class CustomComparator implements Comparator<Integer> {
        private int k;
        public CustomComparator(int k) {
            this.k = k;
        }
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1-this.k) < Math.abs(o2-this.k)){
                return o1;
            }else{
                return o2;
            }
        }
    }
    public static int[]KClosest(int[] points, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator(k));
        for(int num : points){
            if(pq.size()<k){
                pq.add(num);
            }else if((!pq.isEmpty())&&(Math.abs(num-k) < Math.abs(pq.peek()-k))){
                pq.poll();
                pq.add(num);
            }
        }
        int[] result = new int[pq.size()];
        int i=0;
        while (!pq.isEmpty()){
            result[i] = pq.poll();
            i++;
        }
        return result;
    }

    public static void main (String[] args){
        int[] input = {0,1,2,3,4,5,6,7,8,9,10};
        int[] output = KClosest(input, 4);
        for (int num : output){
            System.out.println(num);
        }
    }
}
