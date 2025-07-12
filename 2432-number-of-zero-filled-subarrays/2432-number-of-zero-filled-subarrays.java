class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count0 = 0;
        long totalSubArrays = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
                totalSubArrays += count0;
            } else {
                count0 = 0;
            }
        }
        return totalSubArrays;
    }
}