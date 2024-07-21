package Matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/



/*
        TLDR:
            1. we are doing breadth 1st search
            2. Mark the node as 1 if visited
            3. Minimum  length is 1
        Note: Inside the loop Start with sucess Case of if reached end of matrix return result;
*/

public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        // check for base condition grid size, start and end is not 0
        if((len==0)||(grid[0][0]!=0)||(grid[len-1][len-1]!=0)){
            return -1;
        }

        // BFS --> so need queue storing Matrix cell row and column
        Queue<int[]> q = new LinkedList<>();

        // Add 1st element to queue
        q.add(new int[]{0, 0});

        // is visited to 1
        grid[0][0]=1;

        // Minimum result is 1
        int result = 1;

        // BFS Starts
        while(!q.isEmpty()){
            // Each level is denoted here
            int size = q.size();

            // search path in each level
            for(int i=0; i<size; i++){

                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];

                // Success case when we are at the end of matrix
                if(currX==len-1 && currY==len-1) {     // reached the last square
                    return result;
                }

                // Try all 9 combinations for neighboring nodes and store it newX and newY
                // Range is -1 to 1
                // (currX - 1, currY - 1), (currX - 1, currY + 0), (currX - 1, currY + 1)
                // (currX + 0, currY - 1), (currX + 0, currY + 0), (currX + 0, currY + 1)
                // (currX + 1, currY - 1), (currX + 1, currY + 0), (currX + 1, currY + 1)
                // Note: (currX + 0, currY + 0) won't be considered as it marked 1 */

                for(int j=-1;j<=1;j++){         // Regular Matrix traversal
                    for(int k=-1;k<=1;k++){

                        // next pointer
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
        return -1;
    }

    //Check that new point is within boundaries and not 1 or already visited
    public boolean checkValidPt(int x,int y,int len ,int[][] grid) {
        if(x<0 || y<0 || x>=len || y>=len || grid[x][y]==1){
            return false;
        }else {
            return true;
        }
    }
}
