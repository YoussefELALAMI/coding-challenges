class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsTable = new HashMap<>();
        int n = nums.length;
        for(int i=0; i < n; i++) numsTable.put(nums[i], i);
        for(int i=0; i < n; i++){
            int complement = target - nums[i];
            if (numsTable.containsKey(complement) && numsTable.get(complement) != i){
                return new int[]{i, numsTable.get(complement)};
            }
        }
        return new int[]{};
    }
}