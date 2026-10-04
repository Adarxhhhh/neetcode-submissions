class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int servers = 0;

        int [] rowServ = new int[r];
        int [] colServ = new int[c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    rowServ[i]++;
                    colServ[j]++;
                }
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    if(rowServ[i] > 1 || colServ[j] > 1){
                        servers++;
                    }
                }
            }
        }

    return servers;
    }
}