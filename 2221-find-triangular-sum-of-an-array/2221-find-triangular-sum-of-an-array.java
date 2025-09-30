class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length - 1;
        while (n >= 1) {
            int[] newNums = new int[n];
            for(int i = 0; i < n; i++){
                newNums[i] = (nums[i] + nums[i+1]) % 10;
            }
            nums = newNums;
            n--;
        }
        return nums[0];
    }
}