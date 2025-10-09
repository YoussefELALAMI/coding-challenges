class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longest = 0;

        // Convert the nums list to a Set so we can check for the element' neighbors 
        for(int n: nums) numSet.add(n);

        for(int n : numSet) {
            if(!numSet.contains(n-1)){
                int length = 1;
                int current = n;
                while(numSet.contains(current + 1)){
                    length += 1;
                    current += 1;
                } 
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}