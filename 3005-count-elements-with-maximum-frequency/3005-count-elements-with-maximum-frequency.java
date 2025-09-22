class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int count = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!frequency.containsKey(nums[i])){
                frequency.put(nums[i], 1);
            } else {
                frequency.replace(nums[i], frequency.get(nums[i])+1);
            }
            maxFreq = Math.max(maxFreq, frequency.get(nums[i]));
        }

        for(int i = 0; i < nums.length; i++){
            if(frequency.get(nums[i])==maxFreq) count++;
        }
        return count;
    }
}