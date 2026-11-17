class Solution {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            int val = (nums[i] == 0) ? -1 : 1;
            sum += val;
            if(preSum.containsKey(sum)){
                int diff = i - preSum.get(sum);
                result = (diff > result) ? diff : result;
            } else {
                preSum.put(sum, i);
            }
        }
        return result;
    }
}