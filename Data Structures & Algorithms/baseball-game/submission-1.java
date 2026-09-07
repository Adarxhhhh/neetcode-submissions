class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String str : operations){
            switch(str){
                case "+" : int a = stack.pop();
                            int b = stack.peek();
                            int sum = a + b;
                            stack.push(a);
                            stack.push(sum);
                            break;
                case "C" : stack.pop();
                            break;
                case "D" : int c = stack.peek();
                            stack.push(2 * c);
                            break;
                default : stack.push(Integer.parseInt(str));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

    return sum;
    }
}