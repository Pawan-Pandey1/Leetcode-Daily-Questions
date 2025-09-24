class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0"; //base case 

        StringBuilder res = new StringBuilder();

        //agr ek number neg hai to  append -
        if((numerator < 0) ^ (denominator < 0)) res.append("-");

        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);

        long intPart = num / denom;
        res.append(intPart);

        if(num % denom == 0) return res.toString();

        res.append(".");

        long rem = num % denom;
        Map<Long, Integer> mp = new HashMap<>();
        StringBuilder decimal = new StringBuilder();

        while(rem != 0) {
            if(mp.containsKey(rem)) { //repeat start
                int idx = mp.get(rem);
                decimal.insert(idx, "(");
                decimal.append(")");
                break;
            }
            mp.put(rem, decimal.length());
            rem *= 10;
            decimal.append(rem / denom);
            rem %= denom;
        }
        // System.out.println(decimal);
        res.append(decimal);
        return res.toString();

    }
}