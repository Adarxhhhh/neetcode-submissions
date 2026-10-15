class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            Set<Character> rSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (rSet.contains(board[i][j]))
                        return false;
                    rSet.add(board[i][j]);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            Set<Character> cSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '.') {
                    if (cSet.contains(board[i][j]))
                        return false;
                    cSet.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Set<Character> sudoku = new HashSet<>();
                
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if (board[a + i][b + j] != '.') {
                            if (sudoku.contains(board[a + i][b + j]))
                                return false;
                            sudoku.add(board[a + i][b + j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
