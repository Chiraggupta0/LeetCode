import java.util.*;

class Solution {

    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Pair> q = new LinkedList<>();

        // Multi-source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            for (int k = 0; k < 4; k++) {

                int nr = cur.row + dr[k];
                int nc = cur.col + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[cur.row][cur.col] + 1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        int low = 0;
        int high = 2 * n;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(dist, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(int[][] dist, int mid) {

        int n = dist.length;

        if (dist[0][0] < mid)
            return false;

        Queue<Pair> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][n];

        q.offer(new Pair(0, 0));
        vis[0][0] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            if (cur.row == n - 1 && cur.col == n - 1)
                return true;

            for (int k = 0; k < 4; k++) {

                int nr = cur.row + dr[k];
                int nc = cur.col + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc] &&
                    dist[nr][nc] >= mid) {

                    vis[nr][nc] = true;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return false;
    }
}