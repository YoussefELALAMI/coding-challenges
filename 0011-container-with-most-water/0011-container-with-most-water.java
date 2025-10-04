
import java.awt.geom.Area;class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int length = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = length * minHeight;
            maxWater = Math.max(maxWater, area);
            if (height[left] <= height[right] ) left++;
            else right--;
        }
        return maxWater;
    }
}