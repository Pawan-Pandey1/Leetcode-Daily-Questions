class Solution {
    //DP memonization approach
    private int solve(int i, int currOr, int[] nums, int maxOR, int[][] dp) {
        if (i == nums.length) {
            if (currOr == maxOR) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[i][currOr] != -1) {
            return dp[i][currOr];
        }
        int take = solve(i + 1, currOr | nums[i], nums, maxOR, dp);

        int notTake = solve(i + 1, currOr, nums, maxOR, dp);

        dp[i][currOr] = take + notTake;

        return dp[i][currOr];
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        int maxOR = 0;
        for (int i = 0; i < n; i++) {
            maxOR |= nums[i];
        }

        int[][] dp = new int[n + 1][maxOR + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int currOr = 0;
        return solve(0, currOr, nums, maxOR, dp);
    }
}