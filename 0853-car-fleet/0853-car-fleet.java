class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        
        // Create an array of [position, speed]
        List<List<Integer>> carIs = new ArrayList<>();

        // Monotonic Increasing Stack for the time
        Deque<Double> mis = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            carIs.add(List.of(position[i], speed[i]));
        }

        // Sort the array in a decreasing order (by position)
        carIs.sort((a, b) -> Integer.compare(b.get(0), a.get(0)));

        for(int car = 0; car < n; car++){
            int pos = carIs.get(car).get(0);
            int sp = carIs.get(car).get(1);

            double time = (double) (target - pos) / sp;
            if(mis.isEmpty()){
                mis.push(time);
                continue;
            }

            double top = mis.peek();
            if(time > top){
                mis.push(time);
            }
        }

        return mis.size();
    }
}