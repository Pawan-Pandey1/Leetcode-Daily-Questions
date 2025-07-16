class Solution {
    public int maximumLength(int[] nums) {
        int countEven = 0;
        int countOdd = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                countOdd++;
            } else {
                countEven++;
            }
        }

        int parity = nums[0] % 2;

        int alternating = 1;

        for (int i = 1; i < nums.length; i++) {
            int currParity = nums[i] % 2;
            if (currParity != parity) {
                alternating++;
                parity = currParity;
            }
        }
        return Math.max(alternating, Math.max(countEven, countOdd));
    }
}