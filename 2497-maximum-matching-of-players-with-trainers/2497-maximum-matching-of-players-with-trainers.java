class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int n = players.length;
        int m = trainers.length;

        int l = 0;
        int r = 0;

        int matchCount = 0;

        while (l < n && r < m) {
            if (players[l] <= trainers[r]) {
                matchCount++;
                l++;
                r++;
            } else {
                r++;
            }
        }
        return matchCount;
    }
}