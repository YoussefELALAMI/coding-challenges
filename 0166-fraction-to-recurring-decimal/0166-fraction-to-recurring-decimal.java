class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if ((numerator < 0) ^ (denominator < 0)) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}

/*
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        int modulo = numerator % denominator;
        if (modulo==0) return Integer.toString(numerator / denominator);
        double fraction = numerator * 1.0 / denominator;
        String result = checkRepeating(Double.toString(fraction));
        return result;
    }

    private String checkRepeating(String fraction){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        String[] parts = fraction.split("\\.");
        result.append(parts[0]);
        result.append(".");
        for(int i = 0; i < parts[1].length(); i++){
            char curr = parts[1].charAt(i);
            map.put( curr, map.getOrDefault(curr, 0) + 1);
            if(map.get(curr) > 1){
                result.append("(");
                for(char c : map.keySet()){
                    if(result.toString().equals(parts[0]+".(") && map.get(c) == 1){
                        result.deleteCharAt(result.length()-1);
                        result.append(c);
                        result.append("(");
                    } 
                    else result.append(c);
                }
                result.append(")");
                return result.toString().trim();
            }
        }
        result.append(parts[1]);
        return result.toString().trim();
    }
}
*/