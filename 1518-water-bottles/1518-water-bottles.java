class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumedBottles = 0;
        while (numBottles >= numExchange) {
            int b = numBottles/numExchange;
            consumedBottles += b * numExchange;
            numBottles -= b * numExchange;
            numBottles += b;
        }
        return consumedBottles + numBottles;
    }
}