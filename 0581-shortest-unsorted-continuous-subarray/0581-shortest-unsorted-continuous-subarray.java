class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = nums.length, end = 0;
        for(int left = 0; left < nums.length - 1; left++){
            for(int right = left+1; right < nums.length; right++){
                if(nums[left] > nums[right]){
                    end = Math.max(right, end);
                    start = Math.min(left, start);
                }
            }
        }
        int length = end - start;
        return length < 0 ? 0 : length + 1;
    }
}