class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=nums[0];
        int max_sum_so_far=nums[0];
        int currMax_sum_so_far=nums[0];
        int min_sum_so_far=nums[0];
        int currMin_sum_so_far=nums[0];

        for(int i=1;i<nums.length;i++){
            totalSum+=nums[i];
            currMax_sum_so_far=Math.max(currMax_sum_so_far + nums[i], nums[i]);
            max_sum_so_far=Math.max(max_sum_so_far,currMax_sum_so_far);

            currMin_sum_so_far=Math.min(currMin_sum_so_far + nums[i], nums[i]);
            min_sum_so_far=Math.min(min_sum_so_far,currMin_sum_so_far);
        }

        if (max_sum_so_far < 0) return max_sum_so_far;

        return Math.max(max_sum_so_far, totalSum-min_sum_so_far);
    }
}