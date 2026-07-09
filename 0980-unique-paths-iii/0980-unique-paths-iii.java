class Solution {
    public int rec(int[][]grid,int row,int col,int startRow,int startCol,int endRow,int endCol,int[][]vis,int remaining)
    {
        if(startRow>=row || startRow<0 || startCol>=col || startCol <0) return 0;
        if(grid[startRow][startCol] == -1) return 0;
        if(startRow == endRow && startCol == endCol)
        {
            if (remaining == 1)return 1;
            return 0;
        }
        if(vis[startRow][startCol] == 1) return 0;
        vis[startRow][startCol] = 1;
        remaining--;
        int left =0,right =0,up =0,down =0;        
            left = rec(grid,row,col,startRow,startCol-1,endRow,endCol,vis,remaining);
            right = rec(grid,row,col,startRow,startCol+1,endRow,endCol,vis,remaining);
            up = rec(grid,row,col,startRow-1,startCol,endRow,endCol,vis,remaining);
            down = rec(grid,row,col,startRow+1,startCol,endRow,endCol,vis,remaining);

        vis[startRow][startCol] = 0;
        return left+right+down+up;
    }
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int endRow=0;
        int endCol=0;
        int startRow = 0;
        int startCol = 0;
        int[][]vis = new int[row][col];
        int one =0,two=0,zero=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == 2)
                {
                    endRow=i;
                    endCol=j;
                    two++;
                }
                if(grid[i][j] == 1)
                {
                    startRow = i;
                    startCol = j;
                    one++;
                }
                if(grid[i][j] == 0)
                {
                    zero++;
                }
            }
        }
        int remaining = one+two+zero;
        return rec(grid,row,col,startRow,startCol,endRow,endCol,vis,remaining);
    }
}