class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height=triangle.size();
        int[][]dp=new int[height+1][height+1];

        for(int row=height-1;row>=0;row--){
            for(int col=0;col<=row;col++){
                dp[row][col]=triangle.get(row).get(col)+Math.min(dp[row+1][col],dp[row+1][col+1]);
            }
        }
        return dp[0][0];
    }
}