class Solution {
    public boolean check(int start,int[]vis,int[]pathVis,int[][]graph)
    {
        vis[start] = 1;
        pathVis[start] = 1;
        for (int it:graph[start])
        {
            if(vis[it] == 0)
            {
                if(check(it,vis,pathVis,graph)) return true;
            }
            else if(pathVis[it] == 1)
            {
                return true;
            }
        }
        pathVis[start] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>ans = new ArrayList<>();
        int[]vis = new int[n];
        int pathVis[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(!check(i,vis,pathVis,graph)) ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}