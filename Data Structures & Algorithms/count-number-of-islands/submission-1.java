class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    dfs(grid, row, col);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (!inBounds(grid, row, col) || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
    }

    private boolean inBounds(char[][] grid, int row, int col) {
        return (row > -1) && (row < grid.length) && (col > -1) && (col < grid[0].length);
    }
}
