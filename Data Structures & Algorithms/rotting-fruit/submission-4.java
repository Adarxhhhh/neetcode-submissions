class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int []> queue = new LinkedList<>();
        int [][] dirs = {{0, 1}, {0, - 1}, {1, 0}, {-1, 0}};
        int fresh = 0;
        int time = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottedSomething = false;

            for(int i = 0; i < size; i++){
                int [] curr = queue.poll();

                for(int [] dir : dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 0 || grid[nr][nc] == 2){
                        continue;
                    }

                    rottedSomething = true;
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int []{nr, nc});
                }
            }

            if(rottedSomething) time++;
        }

        return fresh == 0 ? time : -1;
    }
}
