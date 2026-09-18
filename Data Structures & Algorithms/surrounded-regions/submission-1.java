class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }

        for(int j = 0; j < n; j++){
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char [][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }

        board[i][j] = '#';

        bfs(board, i + 1, j);
        bfs(board, i - 1, j);
        bfs(board, i, j + 1);
        bfs(board, i, j - 1);
    }
}
