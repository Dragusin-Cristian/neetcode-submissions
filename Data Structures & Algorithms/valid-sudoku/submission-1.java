class Solution {
    Set<Character> seen;
    public boolean isValidSudoku(char[][] board) {
        this.seen = new HashSet<>();

        // check the rows
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (!isCellValid(board[r][c])) {
                    return false;
                }
            } 
            seen.clear();           
        }
        
        // check the columns
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
               if (!isCellValid(board[r][c])) {
                    return false;
                }
            }  
            seen.clear();                  
        }

        // check the squares
        for (int k = 0; k < 9; k+=3) {
            for (int t = 0; t < 9; t+=3) {
                seen.clear();
                for (int r = k; r <k+3; r++) {                
                    for (int c = t; c < t+3; c++) {
                        if (!isCellValid(board[r][c])) {
                            return false;
                        }
                    }
                }
            
            }
        }

        return true;
    }

    boolean isCellValid(char c) {
        if (c == '.') {
            return true;
        }
        if (seen.contains(c)) {
            return false;
        }
        seen.add(c);
        return true;
    }

}
