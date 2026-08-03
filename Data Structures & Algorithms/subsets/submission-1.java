class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, 0, new ArrayList<Integer>(), result);
        
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> currSet, List<List<Integer>> sets) {
        sets.add(new ArrayList<>(currSet));

        for (int i = start; i < nums.length; i++) {
            // choose
            currSet.add(nums[i]);

            // backtrack
            backtrack(nums, i + 1, currSet, sets);

            // undo
            currSet.remove(currSet.size() - 1);
        }
    }
}
