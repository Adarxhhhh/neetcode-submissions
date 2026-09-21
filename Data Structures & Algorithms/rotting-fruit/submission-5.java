class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int []> queue = new LinkedList<>();
        int time = 0;
        int [][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int freshFruit = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int [] {i, j});
                }else if(grid[i][j] == 1){
                    freshFruit++;
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottedSomething = false;

            for(int i = 0; i < size; i++){
                int [] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int [] dir : dirs){
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 0 || grid[nr][nc] == 2){
                        continue;
                    }

                    grid[nr][nc] = 2;
                    rottedSomething = true;
                    freshFruit--;
                    queue.offer(new int [] {nr, nc});
                }
            }

            if(rottedSomething) time++;
        }

    return freshFruit == 0 ? time : -1;
    }
}
