class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0, occurence = 0;
        Map<Integer, Integer> prefixTable = new HashMap<>();
        prefixTable.put(prefixSum, 1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int complement = prefixSum - k;
            if(prefixTable.containsKey(complement)) occurence += prefixTable.get(complement);
            prefixTable.put(prefixSum, prefixTable.getOrDefault(prefixSum, 0) + 1);
        } 
        return occurence;
    }
    /**
    Brute Force :
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
     */
}