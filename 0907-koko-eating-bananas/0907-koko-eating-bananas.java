class Solution {
    private long canEat(int mid, int[] piles, int h) {
        long count = 0;

        for (int i = 0; i < piles.length; i++) {
            count += (piles[i] + mid - 1L) / mid;
        }
        return count;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > end) {
                end = piles[i];
            }
        }

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canEat(mid, piles, h) <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}