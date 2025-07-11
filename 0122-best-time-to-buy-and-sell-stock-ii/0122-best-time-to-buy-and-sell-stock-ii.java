class Solution {
    private int solve(int idx, int buy, int[] prices, int n, int [][]dp) {
        if (idx == n) {
            return 0;
        }

        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }

        if (buy == 1) {
            int buyStock = -prices[idx] + solve(idx + 1, 0, prices, n, dp);

            int skip = solve(idx + 1, 1, prices, n, dp);

            dp[idx][buy]= Math.max(buyStock, skip);
        } else {
            int sellStock = +prices[idx] + solve(idx + 1, 1, prices, n, dp);

            int skip = solve(idx + 1, 0, prices, n, dp);

            dp[idx][buy]=Math.max(sellStock, skip);
        }

        return dp[idx][buy];

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int [][]dp=new int[n][2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0, 1, prices, n, dp);
    }
}