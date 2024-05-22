package Comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KNN {

//    static class CustomComparator implements Comparator<Integer> {
//        private int pivot;
//        public CustomComparator(int pivot) {
//            this.pivot = pivot;
//        }
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return Integer.compare(Math.abs(o2-this.pivot), Math.abs(o1-this.pivot));
//        }
//    }
    public static int[]KClosest(int[] points, int pivot, int k){
        //PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator(pivot));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Math.abs(b-pivot)-Math.abs(a-pivot));
        for(int num : points){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
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
        int[] output = KClosest(input, 4, 3);
        for (int num : output){
            System.out.println(num);
        }
    }
}
