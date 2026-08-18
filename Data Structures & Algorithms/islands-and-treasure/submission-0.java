class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (
                    nextRow < 0 ||
                    nextRow >= rows ||
                    nextCol < 0 ||
                    nextCol >= cols
                ) {
                    continue;
                }

                if (grid[nextRow][nextCol] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nextRow][nextCol] = grid[row][col] + 1;

                queue.offer(new int[]{nextRow, nextCol});
            }
        }
    }
}