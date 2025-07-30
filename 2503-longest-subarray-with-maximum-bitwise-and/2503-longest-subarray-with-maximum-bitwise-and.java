class Solution {
    public int longestSubarray(int[] nums) {
        int streak = 0;
        int maxAnd = 0;
        int result = 0;

        for (int num : nums) {
            if (num > maxAnd) {
                maxAnd = num;
                streak = 0;
                result = 0;
            }
            if (maxAnd == num) {
                streak++;
            } else {
                streak = 0;
            }
            result = Math.max(streak, result);
        }
        return result;
    }
}