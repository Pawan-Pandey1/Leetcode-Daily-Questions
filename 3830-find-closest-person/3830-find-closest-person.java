class Solution {
    public int findClosest(int x, int y, int z) {
        int distXZ=Math.abs(x-z);
        int distYZ=Math.abs(y-z);

        if(distXZ<distYZ){
            return 1;
        }else if(distXZ>distYZ){
            return 2;
        }else{
            return 0;
        }
    }
}