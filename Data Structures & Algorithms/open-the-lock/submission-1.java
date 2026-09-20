class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadlocks = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if(deadlocks.contains(start))return -1;

        if(start == target) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> seen = new HashSet<>();
        seen.add(start);
        int turns = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            turns++;

            for(int i = 0; i < size; i++){
                String curr = queue.poll();

                for(String next : neighbors(curr)){
                    if(deadlocks.contains(next) || seen.contains(next)) continue;

                    if(next.equals(target)) return turns;

                    seen.add(next);
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    public List<String> neighbors(String str){
        List<String> res = new ArrayList<>(8);
        char [] chars = str.toCharArray();

        for(int i = 0; i < 4; i++){
            char curr = chars[i];

            chars[i] = curr == '9' ? '0' : (char)(curr + 1);
            res.add(new String(chars));
            chars[i] = curr == '0' ? '9' : (char)(curr - 1);
            res.add(new String(chars));
            chars[i] = curr;
        }

    return res;
    }
}