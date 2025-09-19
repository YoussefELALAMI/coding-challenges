class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0], currMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            currMax = Math.max(nums[i] + currMax, nums[i]);
            maxSub = Math.max(currMax, maxSub);
        }
        return maxSub;
    }
}