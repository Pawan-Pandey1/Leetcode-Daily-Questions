class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        int count = 1;

        Arrays.sort(nums);

        int i = 0;
        int j = 0;

        while (j < n) {
            if (nums[j] - nums[i] <= k) {
                j++;
            } else {
                count++;
                i = j;
                j = j + 1;
            }
        }
        return count;
    }
}