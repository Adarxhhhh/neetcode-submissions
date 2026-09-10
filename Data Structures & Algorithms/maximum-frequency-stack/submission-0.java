class FreqStack {

    Map<Integer, Integer> dict;
    List<Integer> stack;

    public FreqStack() {
        dict = new HashMap<>();
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        dict.put(val, dict.getOrDefault(val, 0) + 1);
    }
    
    public int pop() {
        int max = Collections.max(dict.values());
        int i = stack.size() - 1;

        while(dict.get(stack.get(i)) != max){
            i--;
        }

        int val = stack.remove(i);
        if(dict.get(val) == 0) dict.remove(val);
        else dict.put(val, dict.get(val) - 1);

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */