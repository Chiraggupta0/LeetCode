class Solution {
    public boolean check(int start,List<List<Integer>>adj,int[] color)
    {
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1;
        while(!queue.isEmpty())
        {
            int node = queue.remove();
            for(int it:adj.get(node))
            {
                if(color[it] == -1)
                {
                    color[it] = 1-color[node];
                    queue.add(it);
                }
                else
                {
                    if(color[it] == color[node]) return false;
                }
            }

        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        // we are taking 2 colors 0,1
        for(int i=0;i<n;i++)
        {
            if(color[i] == -1)
            {
                if(check(i,adj,color) == false) return false;
            }
        }
        return true;

    }
}