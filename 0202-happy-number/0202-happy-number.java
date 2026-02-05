class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenSet = new HashSet<Integer>();
        if(n == 1) return true;
        while(n != 1) {
            if(!seenSet.add(n)) return false;
            n = sum_digits(n);
        }
        return true;
    }

    private int sum_digits(int num){
        int result = 0;
        while(num > 0) {
            result +=  num >= 10 ? Math.pow(num % 10, 2) : Math.pow(num, 2);
            num /= 10;
        }
        return result;
    }
}