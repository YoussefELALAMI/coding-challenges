class Solution {
    public int fixedPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int diff = arr[mid] - mid;

            if (diff == 0) {
                result = mid;
                right = mid - 1;
            } else if (diff < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 O(n) Solution :
     public int fixedPoint(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(i==arr[i]) return i;
        }
        return -1;
    }
 */