class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();
        if(len == goal.length() && len > 0){
            String concatenate = goal + goal;
            if(concatenate.contains(s)) return true;
        }
        return false;
    }
}