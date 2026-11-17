class Solution {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int val = (nums[i] == 0) ? -1 : 1;
            sum += val;
            if(preSum.containsKey(sum)){
                int diff = i - preSum.get(sum);
                result = (diff > result) ? diff : result;
            } else if(sum == 0){
                result = i + 1;
            } else {
                preSum.put(sum, i);
            }
        }
        return result;
    }
}