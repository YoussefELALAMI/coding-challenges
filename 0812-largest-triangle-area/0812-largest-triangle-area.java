class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;
        for(int a = 0; a < n - 2; a++){
            for(int b = a + 1; b < n - 1; b++){
                for(int c = b + 1; c < n; c++){
                    int xa = points[a][0], xb = points[b][0], xc = points[c][0];
                    int ya = points[a][1], yb = points[b][1], yc = points[c][1];
                    double area  = (1.0/2.0) * Math.abs((xa*(yb-yc))+ (xb*(yc-ya))+ (xc*(ya-yb)));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}