class Solution {
    class Pair{
        int first;
        int second;
        int count;
        Pair(int first,int second,int count)
        {
            this.first = first;
            this.second = second;
            this.count = count;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int max = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int i = p.first;
            int j = p.second;
            max = Math.max(max,p.count);
            int[] row = {-1,0,1,0};
            int[] col = {0,1,0,-1};
            for(int k=0;k<4;k++)
            {
                    int nrow = i+row[k];
                    int ncol = j+col[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]!=0 && grid[nrow][ncol]!=2 )
                    {
                        grid[nrow][ncol] = 2;
                        q.offer(new Pair(nrow,ncol,max+1));
                    }
            }

        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }
        return max;
    }
}