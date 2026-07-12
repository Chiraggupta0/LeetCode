class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int original = image[sr][sc];
        if (original == color) {
            return image;
        }

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc});
        vis[sr][sc] = true;
        image[sr][sc] = color;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int k = 0; k < 4; k++) {
                int nrow = row + dr[k];
                int ncol = col + dc[k];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    !vis[nrow][ncol] &&
                    image[nrow][ncol] == original) {

                    vis[nrow][ncol] = true;
                    image[nrow][ncol] = color;
                    queue.offer(new int[]{nrow, ncol});
                }
            }
        }

        return image;
    }
}