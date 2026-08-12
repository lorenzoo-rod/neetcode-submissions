class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lengths = new int[text1.length()][text2.length()];

        for (int i = 0; i < lengths.length; i++) {
            Arrays.fill(lengths[i], -1);
        }

        return dfs(text1, text2, 0, 0, lengths);
    }

    private int dfs(
        String text1,
        String text2,
        int pos1,
        int pos2,
        int[][] lengths
    ) {
        // Base case
        if (pos1 == text1.length() || pos2 == text2.length()) {
            return 0;
        }

        // Already solved this state
        if (lengths[pos1][pos2] != -1) {
            return lengths[pos1][pos2];
        }

        int result;

        if (text1.charAt(pos1) == text2.charAt(pos2)) {
            result = 1 + dfs(
                text1,
                text2,
                pos1 + 1,
                pos2 + 1,
                lengths
            );
        } else {
            int move1 = dfs(
                text1,
                text2,
                pos1 + 1,
                pos2,
                lengths
            );

            int move2 = dfs(
                text1,
                text2,
                pos1,
                pos2 + 1,
                lengths
            );

            result = Math.max(move1, move2);
        }

        lengths[pos1][pos2] = result;

        return result;
    }
}