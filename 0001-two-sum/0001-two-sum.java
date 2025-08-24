class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) hashNum.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashNum.containsKey(complement) && hashNum.get(complement) != i) {
                return new int[] {i, hashNum.get(complement)};
            }
        }
        
        return new int[] {};
    }
}