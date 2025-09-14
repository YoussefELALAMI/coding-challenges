

import static java.util.Collections.min;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int longestSubArr = 0;
        for(int i=0; i<nums.length; i++){
            prefix += nums[i];
            if(prefix==k) longestSubArr = i+1;
            int complement = prefix-k;
            if(map.containsKey(complement)){
                longestSubArr = Math.max(longestSubArr, i - map.get(complement));
            }
            if(!map.containsKey(prefix)) map.put(prefix, i);
        }
        return longestSubArr;
    }
}