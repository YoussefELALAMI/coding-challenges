class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = -1, vote = 0;
        for(int i = 0; i < n; i++){
            if(vote == 0) candidate = nums[i];
            vote += (candidate == nums[i]) ? 1 : -1;
        }
        return candidate;
    }
}

/**

HashMap-Based Approach

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        int n = nums.length;
        int maj = n / 2;
        for(int i = 0; i < n; i++){
            int value = occ.getOrDefault(nums[i], 0) + 1;
            occ.put(nums[i], value);
            if(value > maj) return nums[i];
        }
        return -1;
    }
}
 */