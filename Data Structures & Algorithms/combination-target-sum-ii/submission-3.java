class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> combos = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), combos);

        return combos;
    }

    private void backtrack(int[] nums, int target, int start, int sum, List<Integer> curr, List<List<Integer>> combos) {

        if (sum == target) {
            combos.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length && nums[i] + sum <= target; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Choose
            curr.add(nums[i]);

            // Backtrack
            backtrack(nums, target, i + 1, sum + nums[i], curr, combos);

            // Undo
            curr.remove(curr.size() - 1);
        }
    }
}
