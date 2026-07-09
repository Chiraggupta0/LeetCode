class Solution {
    // public int rec(int m,int n,int startRow, int startCol,int[][]dp)
    // {
    //     if(startRow>=m || startCol>=n) return 0;
    //     if(dp[startRow][startCol]!=-1) return dp[startRow][startCol];
    //     if(startRow == m-1 && startCol == n-1)
    //     {
    //         return 1;
    //     }
    //     int down = rec(m,n,startRow+1,startCol,dp);
    //     int right = rec(m,n,startRow,startCol+1,dp);
    //     dp[startRow][startCol] = down + right;
    //     return dp[startRow][startCol];
    // }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // for(int i=0;i<dp.length;i++)
        // {
        //     Arrays.fill(dp[i],-1);
        // }
        for(int i=0;i<m;i++) // row bhar di sari
        {
            dp[i][n-1] = 1;
        }
        for(int j=0;j<n;j++) // column bhari sari
        {
            dp[m-1][j] = 1;
        }
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
}