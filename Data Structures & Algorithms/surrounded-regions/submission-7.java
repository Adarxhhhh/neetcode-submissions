class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int []> queue = new LinkedList<>();
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') enqueue(board, i, 0, queue);
            if(board[i][n - 1] == 'O') enqueue(board,i, n - 1, queue);
        }

        for(int j = 1; j < n - 1; j++){
            if(board[0][j] == 'O') enqueue(board, 0, j, queue);
            if(board[m - 1][j] == 'O') enqueue(board, m - 1, j, queue);
        }

        while(!queue.isEmpty()){
            int [] curr = queue.poll();

            for(int [] dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O'){
                    enqueue(board, nr, nc, queue);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void enqueue(char [][] board, int i, int j, Queue<int []> queue){
        board[i][j] = '#';
        queue.offer(new int []{i, j});
    }
}
