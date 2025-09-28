class Solution {
    public int largestPerimeter(int[] nums) {
        int perimeter = 0;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i > 1; i--){
            boolean nonzero = nums[i] < nums[i-1] + nums[i-2];
            if(nonzero) perimeter = Math.max(perimeter, nums[i] + nums[i-1] + nums[i-2]);
        }
        return perimeter;
    }
}