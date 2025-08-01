class Solution {
    public int countNumbers(long curr,long next,int n){
        int countNum=0;

        while(curr<=n){
            countNum+=(next-curr);
            curr*=10;
            next*=10;

            next=Math.min(next,(long)n+1);
        }
        return countNum;
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        ;

        while (k > 0) {
            int count = countNumbers(curr, curr + 1, n);

            if (count <= k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
}