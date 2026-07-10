class Solution {
    public int rec(int[][] grid,int r,int c,int row,int col,int[][]dp)
    {
        if(row == r || col == c) return 1000000;
        if(row == r-1 && col == c-1) return grid[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int down = grid[row][col]+rec(grid,r,c,row+1,col,dp);
        int right = grid[row][col]+rec(grid,r,c,row,col+1,dp);
        return dp[row][col] = Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length+1];
        for(int i=0;i<grid.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return rec(grid,grid.length,grid[0].length,0,0,dp);
    }
}