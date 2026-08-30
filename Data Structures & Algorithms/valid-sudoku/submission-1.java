class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < r; i++){
            Set<Character> rowMap = new HashSet<>();
            
            for(int j = 0; j < c; j++){
                if(board[i][j] != '.'){
                    if(rowMap.contains(board[i][j])) return false;
                    else rowMap.add(board[i][j]);
                }
            }

        }

        for(int i = 0; i < c; i++){
            Set<Character> colMap = new HashSet<>();
            
            for(int j = 0; j < r; j++){
                if(board[j][i] != '.'){
                    if(colMap.contains(board[j][i])) return false;
                    else colMap.add(board[j][i]);
                }
            }

        }

        for(int i = 0; i < r; i+= 3){
            for(int j = 0; j < c; j+= 3){
                Set<Character> sudoku = new HashSet<>();

                for(int a = 0; a < 3; a++){
                    for(int b = 0; b< 3; b++){
                        if(board[i + a][j + b] != '.'){
                            if(sudoku.contains(board[i + a][j + b])) return false;
                            else sudoku.add(board[i + a][j + b]);
                        }
                    }
                }
            }
        }

    return true;
    }
}
