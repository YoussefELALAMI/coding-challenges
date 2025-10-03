class Solution {
    public int minimumCost(int n, int[][] connections) {
        int minCost = Integer.MAX_VALUE;
        boolean costExist = false;
        for(int i = 0; i < connections.length; i++){
            for(int j = i + 1; j < connections.length; j++){
                if(
                    connections[i][0] == connections[j][0]
                    ||
                    connections[i][1] == connections[j][0]
                    ||
                    connections[i][0] == connections[j][1]
                    ||
                    connections[i][1] == connections[j][1]
                ){
                    minCost = Math.min(minCost, connections[i][2] + connections[j][2]);
                    costExist = true;
                }
            }
        }
        if(!costExist) return -1;
        else return minCost;
    }
}