class Solution {

    class Node {
        int r, c, loss;

        Node(int r, int c, int loss) {
            this.r = r;
            this.c = c;
            this.loss = loss;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.loss - b.loss);

        dist[0][0] = grid.get(0).get(0);
        pq.offer(new Node(0, 0, dist[0][0]));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (cur.loss > dist[cur.r][cur.c])
                continue;

            if (cur.r == m - 1 && cur.c == n - 1)
                break;

            for (int i = 0; i < 4; i++) {

                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int newLoss = cur.loss + grid.get(nr).get(nc);

                if (newLoss < dist[nr][nc]) {
                    dist[nr][nc] = newLoss;
                    pq.offer(new Node(nr, nc, newLoss));
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}