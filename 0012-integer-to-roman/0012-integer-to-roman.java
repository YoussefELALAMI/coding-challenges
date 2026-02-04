class Solution {
    public String intToRoman(int num) {
        int[] numbers = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbols = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder result = new StringBuilder();

        for(int i = numbers.length - 1; i >= 0 && num > 0 ; i--){
            while(num >= numbers[i]){
                result.append(symbols[i]);
                num -= numbers[i];
            }
        }

        return result.toString().trim();

    }
}