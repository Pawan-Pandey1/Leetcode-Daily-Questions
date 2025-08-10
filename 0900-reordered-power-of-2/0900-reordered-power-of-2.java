class Solution {
    private String getSorted(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public boolean reorderedPowerOf2(int n) {
        String StringGiven = getSorted(n);

        for (int i = 0; i <= 29; i++) {
            if (StringGiven.equals(getSorted(1 << i))) {
                return true;
            }
        }
        return false;
    }
}