class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] charsArr = strs[i].toCharArray();
            Arrays.sort(charsArr);
            String key = new String(charsArr);
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}