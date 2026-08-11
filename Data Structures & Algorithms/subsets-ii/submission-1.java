class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);

        return subsets;
    }

    private void backtrack(int[] nums, int start, List<Integer> currSet, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currSet));

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            currSet.add(nums[i]);

            backtrack(nums, i + 1, currSet, subsets);

            currSet.remove(currSet.size() - 1);

        }
    }
}
