class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        int k = -1;

        for (int num : nums){
            numSet.add(num);
        }

        for (int num : nums){
            if (num > k && numSet.contains(-num)){
                k = Math.max(k, num);
            }
        }
        return k;
    }
}