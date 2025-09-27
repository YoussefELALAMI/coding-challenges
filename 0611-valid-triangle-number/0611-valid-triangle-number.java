class Solution {
    public int triangleNumber(int[] nums) {
        int numOftriplet = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                int comb = nums[i] + nums[j];
                int k = binarySearch(nums, comb, j+1);
                numOftriplet += k - j - 1;
            }
        }
        return numOftriplet;
    }

    private int binarySearch(int[] nums, int target, int start){
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if(nums[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}