class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals("") && t.equals("")) return false;
        if(s.equals(t)) return false;
        if(Math.abs(s.length() - t.length()) > 1) return false;

        String s1 = s.length() > t.length() ? t : s;
        String s2 = s.length() > t.length() ? s : t;

        boolean oneEdit = false;

        int left = 0, right = 0;

        while (left < s1.length() && right < s2.length()) {
            if(s1.charAt(left) != s2.charAt(right)){
                if (oneEdit) return false;
                oneEdit = true;
                if(s1.length() == s2.length()) left++;
                
            } else {
                left++;
            }
            right++;
        }
        return true;
    }

/*
    private boolean replace(String s1, String s2){
        boolean oneEdit = false;
        for(int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) {
                if (oneEdit) return false;
                oneEdit = true;
            }
        }
        return oneEdit;
    }

    private boolean insert(String s1, String s2){
        int left = 0, right = 0;
        while (left < s1.length() && right < s2.length()) {
            if(s1.charAt(left) == s2.charAt(right)){
                left++;
                right++;
            } else {
                if(left != right) return false;
                right++;
            }
        }
        return true;
    }
*/
}