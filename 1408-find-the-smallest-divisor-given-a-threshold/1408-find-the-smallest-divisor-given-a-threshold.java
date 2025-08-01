class Solution {
    private boolean isPossible(int mid, int[] nums, int threshold) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + mid - 1) / mid;
        }
        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int start = 1;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > end) {
                end = nums[i];
            }
        }

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(mid, nums, threshold)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}