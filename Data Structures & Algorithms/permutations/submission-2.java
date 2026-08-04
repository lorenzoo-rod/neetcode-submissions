class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), perms, new boolean[nums.length]);

        return perms;
    }

    public void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> perms, boolean[] picked) {
        if (curr.size() == nums.length) {
            perms.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (picked[i] == true) {
                continue;
            }

            curr.add(nums[i]);
            picked[i] = true;

            backtrack(nums, curr, perms, picked);

            curr.remove(curr.size() - 1);
            picked[i] = false;
        }
    }
}
