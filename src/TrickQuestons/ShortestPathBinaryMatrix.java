package TrickQuestons;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    //Check that new point is within boundaries and not 1 or already visited
    public boolean checkValidPt(int x,int y,int len ,int[][] grid) {
        if(x<0 || y<0 || x>=len || y>=len || grid[x][y]==1){
            return false;
        }else {
            return true;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if(len==0){
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();        // we will store row and column as array in this queue

        q.add(new int[]{0, 0});                     // we are adding 0,0 node to queue to start with

        grid[0][0]=1;                               // to avoid using HashSet we ll just set the value as blocked (1)

        int result = 1;                             // this is minimum value to return if length is 1

        while(!q.isEmpty()){
            int size = q.size();                    // Level order -- each level we add result

            for(int i=0; i<size; i++){            // pop all items in queue for this level
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];

                if(currX==len-1 && currY==len-1) {     // reached the last square
                    return result;
                }

                // Try all 9 combinations for neighboring nodes and store it newX and newY
                // Range is -1 to 1
                // (currX - 1, currY - 1), (currX - 1, currY + 0), (currX - 1, currY + 1)
                // (currX + 0, currY - 1), (currX + 0, currY + 0), (currX + 0, currY + 1)
                // (currX + 1, currY - 1), (currX + 1, currY + 0), (currX + 1, currY + 1)
                // Note: (currX + 0, currY + 0) won't be considered as it marked 1 */


                for(int j=-1;j<=1;j++){         // Range is -1 to 1
                    for(int k=-1;k<=1;k++){
                        int nextX = currX + j;
                        int nextY = currY + k;
                        if(checkValidPt(nextX, nextY, len, grid)) {
                            q.add(new int[]{nextX, nextY});
                            //Make it 1 here else we will have TLE as some neigbor might add back the currNodes
                            grid[nextX][nextY] = 1;
                        }
                    }
                }
            }
            // On each all queue elements iteration, we traversed by distance 1. Hence, increase by 1
            result++;
        }

        return result;
    }
}
