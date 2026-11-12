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
        return 0;
    }
}