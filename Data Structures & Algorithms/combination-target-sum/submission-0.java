class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combos = new ArrayList<>();
        
        backtrack(nums, 0, new ArrayList<>(), combos, 0, target);

        return combos;
    }

    private void backtrack(int[] nums, int start, List<Integer> currState, List<List<Integer>> combos, int currSum, int target) {
            if (currSum > target) {
                return;
            }

            if (currSum == target) {
                combos.add(new ArrayList<>(currState));
                return;
            }

            for (int i = start; i < nums.length; i++) {
                // Choose
                currState.add(nums[i]);

                // Backtrack
                backtrack(nums, i, currState, combos, currSum + nums[i], target);

                // Undo
                currState.remove(currState.size() - 1);
            }
        }
}
