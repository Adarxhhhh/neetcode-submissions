class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            int currTemp = temperatures[i];

            while(!stack.isEmpty() && currTemp > temperatures[stack.peek()]){
                int prevIdx = stack.pop();
                res[prevIdx] = i - prevIdx;
            }

            stack.push(i);
        }

    return res;
    }
}
