class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
        {
            HashSet<Character> hash = new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == '.') continue;
                if(hash.contains(board[i][j])) return false;
                hash.add(board[i][j]);
            }
        }
        for(int i=0;i<n;i++)
        {
            HashSet<Character> hash = new HashSet<>();
            for(int j=0;j<m;j++)
            {
                if(board[j][i] == '.') continue;
                if(hash.contains(board[j][i])) return false;
                hash.add(board[j][i]);
            }
        }
        int row = 0;
        int col = 0;
        while(row<9 && col<9)
        {
            HashSet<Character> hash = new HashSet<>();
            for(int i=row;i<row+3;i++)
            {
                for(int j=col;j<col+3;j++)
                {
                    if(board[i][j] == '.') continue;
                    if(hash.contains(board[i][j])) return false;
                    hash.add(board[i][j]);
                }
            }
            row+=3;
            if(row == 9)
            {
                row = 0;
                col = col+3;
            }
            
        }
        return true;


    }
}