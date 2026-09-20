class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadlocks = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if(deadlocks.contains(start)) return -1;
        if(start.equals(target)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        int turns = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            turns++;

            for(int i = 0; i < size; i++){
                String curr = queue.poll();

                for(String next : findNeighbors(curr)){
                    if(deadlocks.contains(next) || visited.contains(next)) continue;
                    if(next.equals(target)) return turns;

                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    public List<String> findNeighbors(String str){
        List<String> res = new ArrayList<>(8);
        char [] chars = str.toCharArray();

        for(int i = 0; i < 4; i++){
            char curr = chars[i];

            chars[i] = curr == '9' ? '0' : (char)(curr + 1);
            res.add(new String (chars));
            chars[i] = curr == '0' ? '9' : (char)(curr - 1);
            res.add(new String (chars));

            chars[i] = curr;
        }

    return res;
    }
}