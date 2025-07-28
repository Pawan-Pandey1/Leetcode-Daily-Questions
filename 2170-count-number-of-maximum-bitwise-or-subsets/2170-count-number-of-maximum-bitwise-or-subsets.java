class Solution {
    private int solve(int i, int currOr, int[] nums, int maxOR) {
        if (i == nums.length) {
            if (currOr == maxOR) {
                return 1;
            } else {
                return 0;
            }
        }
        int take = solve(i + 1, currOr | nums[i], nums, maxOR);

        int notTake = solve(i + 1, currOr, nums, maxOR);

        return take + notTake;
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;

        int maxOR = 0;
        for (int i = 0; i < n; i++) {
            maxOR |= nums[i];
        }

        int currOr = 0;
        return solve(0, currOr, nums, maxOR);
    }
}