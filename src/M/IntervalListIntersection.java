package M;

import java.util.ArrayList;
import java.util.List;

/*
    We need to find the over lapping start and end sub points only
*/

/*
    Solution:
    1. To find start of overlap ---->   Max(start1, start2)
    2. To find end of overlap   ----->  Min(end1, end2)
    3. Make sure to remove one with smaller endpoint and go to next ++

    Return
        List<int[]> arrayList = new ArrayList<>();
*/


public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int l1 = 0;
        int l2 = 0;
        List<int[]> arrayList = new ArrayList<>();
        while((l1<firstList.length) && (l2<secondList.length)){

            /*  Let's check if firstList[l1] secondList[l2].
                low - the start point of the intersection
                high - the end point of the intersection
                If A[0] has the smallest endpoint, it can only intersect B[0]. After, we can discard A[0] since it cannot intersect anything else.

             */

            int low = Math.max(firstList[l1][0], secondList[l2][0]);
            int high = Math.min(firstList[l1][1], secondList[l2][1]);

            if(low<=high){
                arrayList.add(new int[]{low, high});
            }

            // Remove the interval with the smallest endpoint
            if(firstList[l1][1]<secondList[l2][1]){
                l1++;
            }else{
                l2++;
            }
        }
        //return answer
        int[][] answer = new int[arrayList.size()][2];
        int idx = 0;
        for(int[] list : arrayList){
            answer[idx][0] = list[0];
            answer[idx][1] = list[1];
            idx++;
        }
        return answer;
    }

}
