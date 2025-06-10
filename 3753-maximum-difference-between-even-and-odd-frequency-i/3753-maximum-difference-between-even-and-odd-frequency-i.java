class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxOdd = 0;
        int maxEven = n+1;

        for (int value : map.values()) {
            if (value % 2 == 1) {
                maxOdd = Math.max(maxOdd, value);
            } else if (value % 2 == 0) {
                maxEven = Math.min(maxEven, value);
            }
        }
        return maxOdd - maxEven;
    }
}