class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = findArea(grid, i, j, m, n);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
    return maxArea;
    }

    public int findArea(int [][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        return 1 + findArea(grid, i + 1, j, m, n) + findArea(grid, i - 1, j, m, n)
                + findArea(grid, i, j + 1, m, n) + findArea(grid, i, j - 1, m, n);
    }
}
