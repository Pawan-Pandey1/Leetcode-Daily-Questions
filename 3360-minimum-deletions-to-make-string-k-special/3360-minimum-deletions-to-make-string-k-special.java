class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int result = word.length();
        int cumulativeDeleted = 0;

        for (int i = 0; i < 26; i++) {

            int delete = cumulativeDeleted;

            for (int j = 25; j > i; j--) {
                if (freq[j] - freq[i] <= k) {
                    break;
                }
                delete += Math.abs(freq[j] - freq[i] - k);
            }
            result = Math.min(result, delete);
            cumulativeDeleted += freq[i];
        }
        return result;
    }
}