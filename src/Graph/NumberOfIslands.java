package Graph;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/




/*
        TLDR:
            1. Doing DFS
            2. Setting visited to '0'
*/
public class NumberOfIslands {
    public static int numIslands(char[][] grid){
        // Check for empty or 0 length
        if((grid==null)||(grid.length==0)){
            return 0;
        }

        int numIsland = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        // MxN matrix traverse and call dfs
        for(int i=0; i<nr; i++){
            for(int j=0; j<nc; j++){
                if(grid[i][j]=='1'){
                    numIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    public static void dfs(char[][] grid, int row, int column){
        int nr = grid.length;
        int nc = grid[0].length;
        // base case --> remember to check for '0'
        if(row<0 || column<0 || row>=nr || column>=nc ||  grid[row][column]=='0' ){
            return;
        }

        // visited = '0'
        grid[row][column] = '0';

        //dfs on all 4 side
        dfs(grid, row-1, column);
        dfs(grid, row+1, column);
        dfs(grid, row, column-1);
        dfs(grid, row, column+1);
    }
}
