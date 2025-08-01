class Solution {
    public int findKthPositive(int[] arr, int k) {
        int idx=0;
        int num=1;
        int count=0;

        while(true){
            if(idx<arr.length && arr[idx]==num){
                idx++;
            }else{
                count++;
                if(count==k){
                    return num;
                }
            }
            num++;
        }

    }
}