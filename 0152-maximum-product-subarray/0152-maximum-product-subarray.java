class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currMul = 1;
            for (int j = i; j < n; j++) {
                currMul *= nums[j];
                max = Math.max(max, currMul);
            }
        }
        return max;
    }
}