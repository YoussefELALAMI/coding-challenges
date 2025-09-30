class Solution {
    public int largestUniqueNumber(int[] nums) {
        Arrays.sort(nums);
        int maxNum = -1;
        Set<Integer> memo = new HashSet<>();
        for(int i = nums.length - 1; i >= 0; i--){
            if(!memo.contains(nums[i])){
              memo.add(nums[i]);
              maxNum = Math.max(maxNum, nums[i]);
            } else{ 
                if(maxNum == nums[i]) maxNum = -1;
            }
        }
        return maxNum;
    }
}