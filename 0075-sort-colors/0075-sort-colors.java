class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1; // Dutch National Flag
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    nums[mid] = nums[low];
                    nums[low] = 0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    nums[mid] = nums[high];
                    nums[high] = 2;
                    high--;
                    break;
            }
        }
    }
}