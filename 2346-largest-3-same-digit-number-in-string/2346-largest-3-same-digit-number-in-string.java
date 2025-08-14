class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String maxGood = "";

        for (int i = 0; i <= n - 3; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);

            if (c1 == c2 && c2 == c3) {
                String curr = "" + c1 + c2 + c3;
                if (maxGood.isEmpty() || c1 > maxGood.charAt(0)) {
                    maxGood = curr;
                }
            }
        }
        return maxGood;
    }
}