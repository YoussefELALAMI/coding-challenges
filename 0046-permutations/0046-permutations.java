class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int n : nums) list.add(n);
        return permutations(list);
    }

    private List<List<Integer>> permutations(List<Integer> list) {
        if (list.isEmpty()){
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        } 

        List<List<Integer>> perms = permutations(list.subList(1, list.size()));
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> p : perms) {
            for(int i = 0; i <= p.size(); i++){
                List <Integer> tempList = new ArrayList<>(p);
                tempList.add(i, list.get(0));
                res.add(tempList);
            }

        }

        return res;
    }
}