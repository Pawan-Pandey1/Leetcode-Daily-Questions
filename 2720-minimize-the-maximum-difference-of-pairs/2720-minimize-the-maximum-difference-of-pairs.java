class Solution {
    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0;
        int n = nums.length;
        int count = 0;

        while (i < n - 1) {
            if ((nums[i + 1] - nums[i]) <= mid) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;

        Arrays.sort(nums);
        int l = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > r) {
                r = nums[i];
            }
        }

        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isValid(nums, mid, p)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}