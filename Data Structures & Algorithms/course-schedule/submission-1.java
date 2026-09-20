class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] req : prereq){
            graph.get(req[1]).add(req[0]);
        }

        //0 --> unexplored ; 1 --> in-progress ; 2 --> explored
        int [] state = new int[n];

        for(int i = 0; i < n; i++){
            if(state[i] == 1) return false;
            if(state[i] == 0 && hasCycle(i, graph, state)) return false;
        }

        return true;
    }

    public boolean hasCycle(int i, List<List<Integer>> graph, int [] state){
        state[i] = 1;

        for(int next : graph.get(i)){
            if(state[next] == 1) return true;
            if(state[next] == 0 && hasCycle(next, graph, state)) return true;
        }

        state[i] = 2;
        return false;
    }
}
