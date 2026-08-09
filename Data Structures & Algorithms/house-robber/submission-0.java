class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] house = new int[nums.length];

        house[0] = nums[0];
        house[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            house[i] = Math.max(house[i - 1], house[i - 2] + nums[i]);
        }

        return house[nums.length - 1];
    }
}
