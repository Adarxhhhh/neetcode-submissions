class Solution {
    public boolean canFinish(int n, int[][] req) {
        //Directed graph where req[0, 1] -> to take 0 you must take 1;
        //this means to complete course 0 you will need course 1;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int [] state = new int[n];

        for(int [] r : req){
            graph.get(r[1]).add(r[0]);
        }

        for(int i = 0; i < n; i++){
            if(state[i] == 1) return false;
            if(state[i] == 0 && hasCycle(i, graph, state))return false;
        }

        return true;
    }

    public boolean hasCycle(int sub, List<List<Integer>> graph, int [] state){
        state[sub] = 1;

        for(int next : graph.get(sub)){
            if(state[next] == 1) return true;
            if(state[next] == 0 && hasCycle(next, graph, state))return true;
        }

        state[sub] = 2;
        return false;
    }
}
