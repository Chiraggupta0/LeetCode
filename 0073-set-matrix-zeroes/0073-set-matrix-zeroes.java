class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer>row = new ArrayList<>();
        List<Integer>col = new ArrayList<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        while(!row.isEmpty())
        {
            int i = row.remove(row.size() - 1);
            int j = col.remove(col.size() - 1);
            for(int k=0;k<matrix.length;k++)
            {
                matrix[k][j] = 0;
            }
            for(int k=0;k<matrix[0].length;k++)
            {
                matrix[i][k] = 0;
            }
        }
    }
}