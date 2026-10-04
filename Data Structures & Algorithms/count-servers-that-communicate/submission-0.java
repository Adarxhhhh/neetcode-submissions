class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int servers = 0;

        int [] rowServ = new int[r];
        int [] colServ = new int[c];

        for(int i = 0; i < r; i++){
            int count = 0;
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
            rowServ[i] = count;
        }

        for(int j = 0; j < c; j++){
            int count = 0;
            for(int i = 0; i < r; i++){
                if(grid[i][j] == 1){
                    count++;
                }
            }

            colServ[j] = count;
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