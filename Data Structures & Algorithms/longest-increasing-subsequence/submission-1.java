class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] DP = new int[nums.length];
        int res = 1;
        DP[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                int curr = 1;
                if (nums[i] > nums[j]) {
                    curr += DP[j];
                }

                max = Math.max(max, curr);
            }

            DP[i] = max;
            res = Math.max(res, max);
        }

        return res;
    }
}
