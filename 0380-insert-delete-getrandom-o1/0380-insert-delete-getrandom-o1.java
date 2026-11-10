class RandomizedSet {

    List<Integer> set;
	HashMap<Integer, Integer> hTable;

    public RandomizedSet() {
        set = new ArrayList<>();
	    hTable = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (hTable.containsKey(val)) {
            return false;
        }
        set.add(val);
	    hTable.put(val, set.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        int size = set.size();
        if (!hTable.containsKey(val)) {
            return false;
        }
        int itemIndex = hTable.get(val);
        if(itemIndex != size - 1){
            int lastVal = set.get(size - 1);
            hTable.remove(lastVal);
            set.set(itemIndex, lastVal);
            hTable.put(lastVal, itemIndex);
        }
        set.remove(size - 1);
        hTable.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = ThreadLocalRandom.current().nextInt(0, set.size());
        return set.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */