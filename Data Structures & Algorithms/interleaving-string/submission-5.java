class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (s3.length() != len1 + len2) {
            return false;
        }

        boolean[][] DP = new boolean[len1 + 1][len2 + 1];

        DP[0][0] = true;

        for (int i = 1; i <= len1; i++) {
            DP[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && DP[i - 1][0];
        }

        for (int i = 1; i <= len2; i++) {
            DP[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && DP[0][i - 1];
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int pos3 = i + j - 1;
                DP[i][j] = (DP[i-1][j] && s1.charAt(i-1) == s3.charAt(pos3)) ||
                    (DP[i][j-1] && s2.charAt(j-1) == s3.charAt(pos3));       
            }
        }
        
        return DP[len1][len2];
    }
}
