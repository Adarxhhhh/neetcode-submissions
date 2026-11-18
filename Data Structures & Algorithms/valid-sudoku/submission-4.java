class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++){
            Set<Character> rowSet = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(rowSet.contains(board[i][j])) return false;
                else if(board[i][j] != '.') rowSet.add(board[i][j]);
            }
        }

        for(int j = 0; j < n; j++){
            Set<Character> colSet = new HashSet<>();
            for(int i = 0; i < n; i++){
                if(colSet.contains(board[i][j])) return false;
                else if(board[i][j] != '.') colSet.add(board[i][j]);
            }
        }

        for(int i = 0; i < n; i+= 3){
            for(int j = 0; j < n; j+= 3){

                Set<Character> sudokuWindow = new HashSet<>();

                for(int a = i; a < i + 3; a++){
                    for(int b = j; b < j + 3; b++){
                        if(sudokuWindow.contains(board[a][b])) return false;
                        else if(board[a][b] != '.') sudokuWindow.add(board[a][b]);
                    }
                }
            }
        }
        
    return true;
    }
}
