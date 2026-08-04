class Solution {
    static int delrow[] = {-1,0,1,0};
    static int delcol[] = {0,1,0,-1};
    public static void dfs(int row,int col,boolean[][]vis,char[][]board)
    {
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == false && board[nrow][ncol] == 'O')
            {
                dfs(nrow,ncol,vis,board);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][]vis = new boolean[n][m];
        // row
        for(int i=0;i<m;i++)
        {
            if(vis[0][i] == false && board[0][i] == 'O')
            {
                dfs(0,i,vis,board);
            }
            if(vis[n-1][i] == false && board[n-1][i] == 'O')
            {
                dfs(n-1,i,vis,board);
            }
        }
        for(int j=0;j<n;j++)
        {
            if(vis[j][0] == false && board[j][0] == 'O')
            {
                dfs(j,0,vis,board);
            }
            if(vis[j][m-1]==false && board[j][m-1] == 'O' )
            {
                dfs(j,m-1,vis,board);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j] == false && board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }

    }
}