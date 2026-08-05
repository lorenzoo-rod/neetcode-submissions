class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int mins = -1;
        int fresh = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] curr = queue.poll();

                int row = curr[0];
                int col = curr[1];
                
                // Explore surroundings
                for (int[] direction: directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow > -1 && newRow < grid.length && newCol > -1 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            mins++;
        }

        return fresh == 0 ? mins : -1;
    }
}
