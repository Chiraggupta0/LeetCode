class Solution {
    // public int rec(int[][] obstacleGrid ,int row,int col,int startRow,int startCol,int[][]dp)
    // {
    //     if(startRow>=row || startCol>=col) return 0;
    //     if(obstacleGrid[startRow][startCol] == 1) return 0;
    //     if(dp[startRow][startCol]!=-1) return dp[startRow][startCol];
    //     if(startRow == row-1 && startCol == col-1) return 1;
    //     int down = rec(obstacleGrid,row,col,startRow+1,startCol,dp);
    //     int right = rec(obstacleGrid,row,col,startRow,startCol+1,dp);
    //     dp[startRow][startCol] = down+right;
    //     return dp[startRow][startCol];
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][]dp = new int[row][col];
        // for(int i=0;i<row;i++)
        // {
        //     Arrays.fill(dp[i],-1);
        // }
        for(int i=row-1;i>=0;i--) // col bhare
        {
            if(obstacleGrid[i][col-1] == 1) break;
            dp[i][col-1] = 1;
        }
        for(int i=col-1;i>=0;i--) // row bhare
        {
            if(obstacleGrid[row-1][i] == 1) break;
            dp[row-1][i]= 1;
        }
        for(int i=row-2;i>=0;i--)
        {
            for(int j=col-2;j>=0;j--)
            {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}