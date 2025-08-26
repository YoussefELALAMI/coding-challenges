class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min_price = Integer.MAX_VALUE;
        for (int i = 0; i<prices.length; i++){
            if (prices[i]<min_price) min_price = prices[i];
            else profit = Math.max(profit, prices[i] - min_price);
        }
        return profit;
    }
}