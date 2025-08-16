class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        getCombinations(candidates, target, combinations, 0, comb);
        return combinations;
    }

    private void getCombinations(
        int[] candidates,
        int remain,
        List<List<Integer>> combinations,
        int candidate,
        List<Integer> comb
        ) {

        if (remain == 0){
            combinations.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) return;

        for (int i = candidate; i < candidates.length; i++) {
            comb.add(candidates[i]);
            getCombinations(candidates, remain - candidates[i], combinations, i, comb);
            comb.removeLast();
        }
    }
}