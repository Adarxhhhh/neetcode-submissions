class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int []> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        int dist = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            dist++;
            System.out.println(dist);

            for(int i = 0; i < size; i++){
                int [] curr = queue.poll();
                
                for(int [] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] <= dist)continue;
                    else{
                        grid[nr][nc] = dist;
                        queue.offer(new int [] {nr, nc});
                    }
                }
            }
        }
    }
}
