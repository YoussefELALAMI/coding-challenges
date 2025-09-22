class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int count = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
            maxFreq = Math.max(maxFreq, frequency.get(nums[i]));
        }

        for(int i = 0; i < nums.length; i++){
            if(frequency.get(nums[i])==maxFreq) count++;
        }
        return count;
    }
}