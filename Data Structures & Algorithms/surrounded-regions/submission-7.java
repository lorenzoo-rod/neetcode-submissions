class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        boolean[][] edge = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((row == 0 || row == rows - 1) || (col == 0 || col == cols - 1)) {
                    if (board[row][col] == 'O') {
                        edge[row][col] = true;
                        dfs(board, visited, edge, row, col);
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (edge[row][col] == false && board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, boolean[][] edge, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            if (visited[row][col] == false) {
                visited[row][col] = true;
                if (board[row][col] == 'O') {
                    edge[row][col] = true;
                    dfs(board, visited, edge, row - 1, col);
                    dfs(board, visited, edge, row + 1, col);
                    dfs(board, visited, edge, row, col - 1);
                    dfs(board, visited, edge, row, col + 1);
                }
            }

        }
    }
}
