class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
                max = prices[i];
            } else if (max < prices[i]) {
                max = prices[i];
                profit = max - min;
            }
        }
        return profit;
    }
}