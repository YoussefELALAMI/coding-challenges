class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> mis = new ArrayDeque<>(); // Montonic Increasing Stack

        for(int i = 0; i < temperatures.length; i++){
            int currDay = temperatures[i];
            while(!mis.isEmpty() && currDay > temperatures[mis.peek()]){
                int prevDay = mis.pop();
                answer[prevDay] = i - prevDay;
            }
            mis.push(i);
        }
        return answer;
    }
}