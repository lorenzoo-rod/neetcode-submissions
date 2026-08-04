class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), perms);

        return perms;
    }

    public void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> perms) {
        if (curr.size() == nums.length) {
            perms.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }

            curr.add(nums[i]);
            backtrack(nums, curr, perms);
            curr.remove(curr.size() - 1);
        }
    }
}
