class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i : nums){
            total += i;
        }
        if (total % 2 != 0){
            return 0;
        } else {
            return n - 1;
        }
    }
}