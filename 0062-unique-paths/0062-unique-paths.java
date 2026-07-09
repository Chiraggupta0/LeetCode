class Solution {
    public int rec(int m,int n,int startRow, int startCol,int[][]dp)
    {
        if(startRow>=m || startCol>=n) return 0;
        if(dp[startRow][startCol]!=-1) return dp[startRow][startCol];
        if(startRow == m-1 && startCol == n-1)
        {
            return 1;
        }
        int down = rec(m,n,startRow+1,startCol,dp);
        int right = rec(m,n,startRow,startCol+1,dp);
        dp[startRow][startCol] = down + right;
        return dp[startRow][startCol];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return rec(m,n,0,0,dp);
    }
}