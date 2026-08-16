class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(prices, 0, 0, dp);
    }

    private int dfs(int[] prices, int i, int hasStock, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][hasStock] != -1) {
            return dp[i][hasStock];
        }

        if (hasStock == 0) {
            int noBuy = dfs(prices, i + 1, 0, dp);
            int buy = -prices[i] + dfs(prices, i + 1, 1, dp);

            dp[i][hasStock] = Math.max(noBuy, buy);
            return dp[i][hasStock];
        }

        if (hasStock == 1) {
            int sell = prices[i] + dfs(prices, i + 2, 0, dp);
            int noSell = dfs(prices, i + 1, 1, dp);

            dp[i][hasStock] = Math.max(sell, noSell);
            return dp[i][hasStock];
        }

        return 0;
    }
}
