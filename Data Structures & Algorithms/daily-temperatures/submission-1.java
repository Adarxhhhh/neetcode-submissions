class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stack = new Stack<>();
        int l = temps.length;
        int [] res = new int[l];

        for(int i = l - 1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(temps[i] >= temps[stack.peek()]){
                while(!stack.isEmpty() && temps[i] >= temps[stack.peek()]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }else{
                    res[i] = stack.peek() - i;
                    stack.push(i);
                }
            }else{
                res[i] = stack.peek() - i;
                stack.push(i);
            }
        }

    return res;
    }
}
