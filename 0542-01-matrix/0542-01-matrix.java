class Solution {
    class Node{
        int first;
        int second;
        int third;
        Node(int first,int second,int third)
        {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j] == 0)
                {
                    queue.add(new Node(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!queue.isEmpty())
        {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.remove();
            dist[row][col] = steps;
            for(int i=0;i<4;i++)
            {
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                if(nrow>=0 && nrow<n && ncol<m && ncol>=0 && vis[nrow][ncol] == 0 )
                {
                    vis[nrow][ncol] = 1;
                    queue.add(new Node(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
}