class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int minSoFar=nums[0];
        int result=-1;

        for(int i=1;i<n;i++){
            if(nums[i]>minSoFar){
                result=Math.max(result,(nums[i]-minSoFar));
            }else{
                minSoFar=nums[i];
            }
        }
        return result;
    }
}