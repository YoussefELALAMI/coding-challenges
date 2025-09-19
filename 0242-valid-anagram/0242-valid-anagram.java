class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(char c : s.toCharArray()){
            if (map.containsKey(c)) {
                int occ = map.get(c);
                map.replace(c, occ+1);
            } else map.put(c, 1);
        }
        for(char c: t.toCharArray()){
            if(map.containsKey(c) && map.get(c)>0){
                map.replace(c, map.get(c)-1);
            } else return false;
        }
        return true;
    }
}