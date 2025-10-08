class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occMap = new HashMap<>();
        for(int n : nums) occMap.put(n, occMap.getOrDefault(n,0) + 1);

        List<Integer>[] count = new ArrayList[nums.length + 1];

        for(int i = 0; i <= nums.length; i++) {
            count[i] = new ArrayList<>();
        }

        for(int key : occMap.keySet()){
            int value = occMap.get(key);
            count[value].add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for(int freq = count.length - 1; freq >= 0 && index < k; freq--){
            for(int n : count[freq]){
                result[index++] = n;
                if(index == k) return result;
            }
        }
        return result;
    }
}