

import static java.lang.Math.min;

class Solution {
    int n;
    int[] values;
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int minScoreTriangulation(int[] values) {
        this.n = values.length;
        this.values = values;
        return dp(0, n-1);
    }

    private int dp(int start, int end){
        if(start+1 == end) return 0;
        if(start+2 == end) return values[start] * values[start+1] * values[end];
        int key = start * n + end;
        if(!memo.containsKey(key)){
            int minScore = Integer.MAX_VALUE;
            for(int k = start+1; k < end; k++){
                minScore = min(
                    minScore,
                    dp(start, k) + dp(k, end) + values[start] * values[k] * values[end]
                    );
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }
}