class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedSomething = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x < 0 || y < 0 || x >= m || y >= n|| grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y});
                    freshCount--;
                    rottedSomething = true;
                }
            }

            if(rottedSomething) time++;
        }

        return freshCount == 0 ? time : - 1;
    }
}
