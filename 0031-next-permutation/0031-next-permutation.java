class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //** Two Pointer Approach */
        // 1. We start with a left pointer at the position n - 2
        int left = n - 2;

        // 2. Find the position where nums[left] < nums[left + 1]
        while (left >= 0 && nums[left] >= nums[left + 1])
            left--;

        // 3. If we find it, we add a right pointer at n - 1
        if (left >= 0) {
            int right = n - 1;

            // 4. We iterate through the array, until we find a right element that is (NEXT) bigger than the left element
            while (nums[left] >= nums[right])
                right--;

            //5. Then we swap the right element with the left one
            swap(nums, left, right);
        }

        // 6. At the end we sort the rest of the array (or the whole aray if it's the biggest permutation => left < 0)
        reverse(nums, left + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}