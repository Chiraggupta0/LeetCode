class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second  = second;
        }
    }
    public void dfs(int row, int col, int[][] vis, char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.first;
            int c = cur.second;

            for(int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                grid[nrow][ncol] == '1' &&
                vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == '1')
                {
                    count++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
}