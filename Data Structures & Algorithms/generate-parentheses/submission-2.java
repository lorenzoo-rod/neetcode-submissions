class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n - 1, n, "(", res);

        return res;
    }

    private void backtrack(int left, int right, String curr, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curr);
        }

        if (left > 0) {
            backtrack(left - 1, right, curr + "(", res);
        }

        if (right > 0 && right > left) {
            backtrack(left, right - 1, curr + ")", res);
        }
    }
}
