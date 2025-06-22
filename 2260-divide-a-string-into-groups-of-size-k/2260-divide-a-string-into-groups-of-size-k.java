class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();

        int groups = (n + k - 1) / k;

        String[] result = new String[groups];

        for (int i = 0; i < groups; i++) {
            int start = i * k;

            StringBuilder group = new StringBuilder();

            for (int j = start; j < start + k; j++) {
                if (j < n) {
                    group.append(s.charAt(j));
                } else {
                    group.append(fill);
                }
            }
            result[i] = group.toString();

        }
        return result;
    }
}