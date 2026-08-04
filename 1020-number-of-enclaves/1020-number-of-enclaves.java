class Solution {
    static int[]delrow = {-1,0,1,0};
    static int[]delcol = {0,1,0,-1};
    public static void dfs(int row,int col,boolean[][]vis,int[][]grid)
    {
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == false && grid[nrow][ncol] == 1)
            {
                dfs(nrow,ncol,vis,grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]vis=new boolean[n][m];
        for(int i=0;i<m;i++)
        {
            if(vis[0][i] == false && grid[0][i] == 1)
            {
                dfs(0,i,vis,grid);
            }
            if(vis[n-1][i] == false && grid[n-1][i] == 1)
            {
                dfs(n-1,i,vis,grid);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i][0] == false && grid[i][0] == 1)
            {
                dfs(i,0,vis,grid);
            }
            if(vis[i][m-1] == false && grid[i][m-1] == 1)
            {
                dfs(i,m-1,vis,grid);
            }
        }
        int cnt=0;
        // int ones = 0;
        // int visone = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                // if(grid[i][j] == 1)ones++;
                if(vis[i][j] == false && grid[i][j] == 1) cnt++;
            }
        }
        return cnt;
        
    }
}