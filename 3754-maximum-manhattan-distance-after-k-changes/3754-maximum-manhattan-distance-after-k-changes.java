class Solution {
    public int maxDistance(String s, int k) {
        int maxMD = 0;
        
        int east = 0;
        int west = 0;
        int north = 0;
        int south = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'E')
                east++;
            else if (ch == 'W')
                west++;
            else if (ch == 'N')
                north++;
            else if (ch == 'S')
                south++;

            int steps = i + 1;

            int currMD = Math.abs(east - west) + Math.abs(north - south);

            int wastedSteps = steps - currMD;

            int extra = 0;
            if (steps != currMD) {
                extra = Math.min(2 * k, wastedSteps);
            }

            int finalMD = currMD + extra;

            maxMD = Math.max(maxMD, finalMD);
        }
        return maxMD;
    }
}