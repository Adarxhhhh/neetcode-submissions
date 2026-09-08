class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String [] parts = path.split("/");
        
        for(String part : parts){

            if(part.isEmpty() || part.equals(".")) continue;

            if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(part);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append("/").append(stack.pollLast());
        }

        return sb.toString();
    }
}