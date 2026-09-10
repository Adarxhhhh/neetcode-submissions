class Solution {
    public String simplifyPath(String path) {
        String [] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for(String part : parts){
            if(part.equals(".") || part.isEmpty()) continue;

            if(part.equals("..")){
                if(!stack.isEmpty())stack.pop();
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