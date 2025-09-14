class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==k) total++;
            int val = nums[i];
            for(int j = i + 1; j<nums.length; j++){
                val += nums[j];
                if(val==k){
                    total++;
                }
            }
        }
        return total;
    }
}