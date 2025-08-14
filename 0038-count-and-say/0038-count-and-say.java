class Solution {
    public String countAndSay(int n) {
        StringBuilder encoded = new StringBuilder();
        encoded.append("1");
        for (int i = 0; i < n - 1; i++){
            encoded.replace(0,encoded.length(),rle(encoded));
        }
        return encoded.toString().trim();
    }

    private String rle(StringBuilder encoded) {
        String input = encoded.toString();
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < input.length()) {
            char currentChar = input.charAt(i);
            int count = 1;
            
            while (i + 1 < input.length() && input.charAt(i + 1) == currentChar) {
                count++;
                i++;
            }
            
            result.append(count).append(currentChar);
            i++;
        }
        
        return result.toString();
    }
}