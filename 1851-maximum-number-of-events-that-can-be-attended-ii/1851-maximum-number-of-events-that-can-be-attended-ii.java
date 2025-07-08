class Solution {
    public int solve(int[][] events, int idx, int k){
        int n=events.length;

        if(idx>=n || k==0){
            return 0;
        }

        int start=events[idx][0];
        int end=events[idx][1];
        int value=events[idx][2];

        int skip=solve(events,idx+1,k);

        int j = idx + 1;
        while (j < n && events[j][0] <= events[idx][1]) {
            j++;
        }
        
        int take=value+solve(events,j,k-1);

        return Math.max(skip,take);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));

        return solve(events,0,k);
    }
}