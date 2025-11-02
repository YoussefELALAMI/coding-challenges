class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i]!=nums[i-1]) twoSum(nums, i, triplets);
        }
        return triplets;
    }

    private void twoSum(int[] nums, int index, List<List<Integer>> triplets){
        int left = index + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[index] + nums[left] + nums[right];
            if (sum > 0) right--;
            else if(sum < 0) left++;
            else{
                triplets.add(Arrays.asList(nums[index], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) left++;
            }
        }
    }
}