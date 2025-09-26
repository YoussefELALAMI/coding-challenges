class Solution {
    public int triangleNumber(int[] nums) {
        int numOftriplet = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    int comb1 = nums[i] + nums[j];
                    if(comb1 > nums[k]) numOftriplet++;
                }
            }
        }
        return numOftriplet;
    }
}