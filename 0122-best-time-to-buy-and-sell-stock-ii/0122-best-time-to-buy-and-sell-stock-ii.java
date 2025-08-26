class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (max > prices[i]) {
                profit += (max - min);
                min = prices[i];
                max = prices[i];
            }
            if (min > prices[i]) {
                min = prices[i];
                max = prices[i];
            } 
            if (max < prices[i]) {
                max = prices[i];
            }
        }
        profit += (max - min);
        return profit;
    }
}