class Solution {
    public boolean check(List<List<Integer>>adj,int start,int[]vis,int[]pathvis,List<Integer>ans)
    {
        vis[start] = 1;
        pathvis[start] = 1;
        for(int it:adj.get(start))
        {
            if(vis[it] == 0)
            {
                if(check(adj,it,vis,pathvis,ans)) return true;
            }
            else if(pathvis[it] !=0)
            {
                return true;
            }
        }
        pathvis[start] = 0;
        ans.add(start);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            // adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (check(adj,i, vis, pathVis, ans)) {
                    return new int[0];
                }
            }
        }
        Collections.reverse(ans);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}