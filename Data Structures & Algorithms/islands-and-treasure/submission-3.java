class Solution {

    class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dist = 0;
        int [][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    queue.offer(new Node(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            dist++;

            for(int i = 0; i < size; i++){
                Node curr = queue.poll();

                for(int [] dir : dirs){
                    int nr = curr.x + dir[0];
                    int nc = curr.y + dir[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] <= dist){
                        continue;
                    }

                    grid[nr][nc] = dist;
                    queue.offer(new Node(nr,nc));
                }
            }
        }
    }
}
