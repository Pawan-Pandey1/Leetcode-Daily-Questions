class Solution {
    public int maxSum(int[] nums) {
        int maxElement = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxElement = nums[i];
            }
            set.add(nums[i]);
        }

        if (maxElement < 0) {
            return maxElement;
        }

        int result = 0;

        for (int val : set) {
            if (val >= 0) {
                result += val;
            }
        }
        return result;
    }
}