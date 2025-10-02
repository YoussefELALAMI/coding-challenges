class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = numBottles, drunkBottles = numBottles;
        numBottles = 0;
        while (emptyBottles >= numExchange || numBottles > 0) {
            if(emptyBottles >= numExchange){
                emptyBottles -= numExchange;
                numBottles++;
                numExchange++;
            } else if(numBottles > 0){
                emptyBottles += numBottles;
                drunkBottles += numBottles;
                numBottles = 0;
            }
        }
        return drunkBottles;
    }
}