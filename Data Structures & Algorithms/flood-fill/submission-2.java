class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currCol = image[sr][sc];
        if(image[sr][sc] == color){
            return image;
        }
        
        int m = image.length;
        int n = image[0].length;

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {sr, sc});
        image[sr][sc] = color;
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            int [] curr = queue.poll();

            for(int [] dir : dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || image[nr][nc] != currCol){
                    continue;
                }

                image[nr][nc] = color;
                queue.offer(new int []{nr, nc});
            }
        }
    return image;
    }
}