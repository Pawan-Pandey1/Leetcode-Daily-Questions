class Solution {
    public int maxAdjacentDistance(int[] nums) {
        
        int maxDiff=Integer.MIN_VALUE;

        for(int i=1;i<nums.length;i++){
            int diff= Math.abs (nums[i]-nums[i-1]) ;
                if(diff>maxDiff){
                    maxDiff=diff;
                }
        }
        int rotationalDiff= Math.abs(nums[nums.length-1]-nums[0]);

        return rotationalDiff>maxDiff ? rotationalDiff : maxDiff;
    }
}