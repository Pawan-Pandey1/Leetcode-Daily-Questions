class Solution {
    public boolean isSafe(int row, int col, char val, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) {
                return false;
            }
            if (board[i][col] == val) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
                return false;
            }
        }
        return true;
    }

    public boolean solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == '.') {
                    for (char val = '1'; val <= '9'; val++) {
                        if (isSafe(i, j, val, board)) {
                            board[i][j] = val;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}