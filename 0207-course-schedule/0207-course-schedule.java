class Solution {
    public static boolean cycle(int src, List<List<Integer>> adj,int[] vis, int[] pathVis) {
        vis[src] = 1;
        pathVis[src] = 1;
        for(int node : adj.get(src)) {
            if(vis[node] == 0) {
                if(cycle(node, adj, vis, pathVis))return true;
            }
            else if(pathVis[node] == 1) {
                return true;
            }
        }
        pathVis[src] = 0;
        return false;
    }
    public boolean canFinish(int V, int[][] edges) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                if(cycle(i, adj, vis, pathVis))return false;
            }
        }
        return true;
    }
}