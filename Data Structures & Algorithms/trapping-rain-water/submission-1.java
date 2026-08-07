class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = 0;

        int total = 0;

        for (int i = 0; i < height.length; i++) {
            // Calculate amount of water trapped
            int water = Math.min(height[l], height[r]) - height[i];
            if (water > 0) {
                total += water;
            }

            // Update l if a new max left boundary exists
            if (height[i] > height[l]) {
                l = i;
            }

            // Find new right boundary if needed
            if (i == r) {
                r++;

                for (int j = r; j < height.length; j++) {
                    if (height[j] >= height[r]) {
                        r = j;
                    }
                }
            }
        }

        return total;
    }
}
