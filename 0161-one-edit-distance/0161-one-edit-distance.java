class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals("") && t.equals("")) return false;
        if(s.equals(t)) return false;
        if(Math.abs(s.length() - t.length()) > 1) return false;

        String s1 = s.length() < t.length() ? s : t;
        String s2 = s.length() < t.length() ? t : s;

        int index1 = 0, index2 = 0;
        boolean foundDiff = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)){
                if (foundDiff) return false;
                foundDiff = true;
                if (s.length() == t.length()) index1++;
            } else index1++;
            index2++;
        }
        return true;
    }

/**
* Brute Force Implementation :
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == t.length()) return checkReplace(s, t);
        else if(s.length() - 1 == t.length()) return checkInsertOrRemove(t, s);
        else if(s.length() + 1 == t.length()) return checkInsertOrRemove(s, t);
        return false;
    }
    private boolean checkInsertOrRemove(String s, String t) {
        int index1 = 0, index2 = 0;
        while (index1 < s.length() && index2 < t.length()) {
            if(s.charAt(index1) != t.charAt(index2)){
                if(index1 != index2) return false;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
    

    private boolean checkReplace(String s, String t) {
        boolean foundDiff = false;
        if (t.length() == s.length()) {
            for(int i = 0; i < t.length(); i++){
                if (foundDiff && t.charAt(i) != s.charAt(i)) return false;
                if(t.charAt(i) != s.charAt(i)) foundDiff = true;
            }
        }
        return foundDiff;
    }
*/
}