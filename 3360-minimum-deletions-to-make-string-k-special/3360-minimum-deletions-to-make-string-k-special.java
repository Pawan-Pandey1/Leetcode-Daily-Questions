class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        int result = word.length();

        for (int i = 0; i < 26; i++) {

            int deletion = 0;

            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    continue;
                } else if (freq[j] < freq[i]) {
                    deletion += freq[j];
                } else if (Math.abs(freq[j] - freq[i]) > k) {
                    deletion += Math.abs(freq[j] - freq[i] - k);
                }
            }
            result = Math.min(result, deletion);
        }
        return result;
    }
}