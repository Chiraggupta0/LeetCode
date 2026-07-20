class Solution {
    public static int live(int [][] board,int i,int j)
    {
        int l = 0;
        for(int row = i-1;row<=i+1;row++)
        {
            for(int col=j-1;col<=j+1;col++)
            {
                if(row == i && col == j) continue;
                if(row<0 || row>=board.length || col<0 || col>=board[0].length) continue;
                if(board[row][col] == 1 || board[row][col] == 20) l++;
            }
        }
        return l;
    }
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int l = live(board,i,j);
               if(board[i][j] == 1)
            {
                if(l < 2)
                {
                    board[i][j] = 20;
                }
                else if(l == 2 || l == 3)
                {
                    board[i][j] = 1;
                }
                else
                {
                    board[i][j] = 20;
                }
            }
            else
            {
                if(l == 3)
                {
                    board[i][j] = 10;
                }
                else
                {
                    board[i][j] = 0;
                }
            }

            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j] == 10) board[i][j] = 1;
                else if(board[i][j] == 20) board[i][j] =0;
            }
        }
    }
}