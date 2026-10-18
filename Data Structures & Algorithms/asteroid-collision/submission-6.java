class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids){
            boolean destroyed = false;

            while(!stack.isEmpty() && (a < 0 && stack.peek() > 0)){
                if(stack.peek() < -a){
                    stack.pop();
                }else{
                    if(stack.peek() == -a)stack.pop();
                    destroyed = true;
                    break;
                }
            }

            if(!destroyed){
                stack.push(a);
            }
        }

        int [] res = new int[stack.size()];
        int idx = res.length - 1;

        while(!stack.isEmpty()){
            res[idx--] = stack.pop();
        }

    return res;
    }
}