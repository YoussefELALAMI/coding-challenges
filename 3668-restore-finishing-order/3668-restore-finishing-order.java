class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] results = new int[friends.length];
        int index = 0;
        HashSet<Integer> friendsSet = new HashSet<>();
        for(int i = 0; i < friends.length; i++) friendsSet.add(friends[i]);
        for(int i = 0; i < order.length; i++){
            if(friendsSet.contains(order[i])){
                results[index] = order[i];
                index++;
            }
        }
        return results;
    }
}