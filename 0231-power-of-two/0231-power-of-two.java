class Solution {
    public boolean isPowerOfTwo(int n) {
        int x=n&(n-1);
        return (n>0 && x==0);
    }
}