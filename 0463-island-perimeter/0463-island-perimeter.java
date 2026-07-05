class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int islandPerimeter(int[][] mat) {
        int ans = 0;
        int r = mat.length;
        int c = mat[0].length;
        
        // for(int i=0;i<r;i++)
        // {
        //     for(int j=0;j<c;j++)
        //     {
        //         if(mat[i][j] == 0) continue;
        //         if(i-1<0 ||mat[i-1][j] == 0) ans+=1;
        //         if(i+1>=r ||mat[i+1][j] == 0) ans+=1;
        //         if(j-1<0 ||mat[i][j-1] == 0) ans+=1;
        //         if(j+1>=c ||mat[i][j+1] == 0) ans+=1;
        //     }
        // }
        // System.out.print(ans);
        int[][] vis = new int[r][c];
        
       
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(mat[i][j] == 0) continue;
                else
                {
                    q.offer(new Pair(i,j));
                    vis[i][j] = 1;
                    break;
                }
            }
        }
        int[] row = {-1,1,0,0};
        int[] col = {0,0,-1,1};
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int pr = p.first;
            int pc = p.second;
            for(int j=0;j<4;j++)
            {
                int cl = col[j]+pc;
                int rw = row[j]+pr;
                if(cl<0 || cl>=c || rw<0 || rw>=r)
                {
                    ans+=1;
                    continue;
                }        
                if(mat[rw][cl] == 0) ans+=1;
                else if(vis[rw][cl] == 0)
                {
                    vis[rw][cl] = 1;
                    q.offer(new Pair(rw,cl));
                }
            }
            
        }
        return ans;
    }
}