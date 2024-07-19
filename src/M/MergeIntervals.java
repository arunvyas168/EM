package M;

import java.util.Arrays;
import java.util.LinkedList;


/*
    SOLUTION ---> SORT start time
                    Use Linkedlist to get last
                    just keep editing last
*/


public class MergeIntervals {

    public LinkedList<int[]> mergeListIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);       //nlogn
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] interval: intervals){
            if((result.isEmpty()) || (result.getLast()[1]<interval[1])){
                result.add(interval);
            }else{
                result.getLast()[1] = Math.max(result.getLast()[1],interval[1]);
            }
        }
        return result;
    }
}
