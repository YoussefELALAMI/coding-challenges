class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            return replace(s, t);
        } else if (s.length() - t.length() == 1){
            return insert(t, s);
        } else if (t.length() - s.length() == 1){
            return insert(s, t);
        }
        return false;
    }

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
}