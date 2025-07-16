class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int element = nums[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        int freq = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                freq++;
            }
        }

        if (freq > n / 2) {
            return element;
        } else {
            return -1;
        }
    }
}