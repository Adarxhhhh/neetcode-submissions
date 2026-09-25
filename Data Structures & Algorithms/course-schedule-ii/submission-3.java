class Solution {
    int [] res;
    int idx;
    public int[] findOrder(int n, int[][] req) {
        res = new int[n];
        idx = n - 1;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int [] r : req) graph.get(r[1]).add(r[0]);

        int [] state = new int[n];

        for(int i = 0; i < n; i++){
            if(state[i] == 1 || (state[i] == 0 && hasCycle(i, graph, state))) return new int[] {};
        }

        return res;
    }

    public boolean hasCycle(int curr, List<List<Integer>> graph, int [] state){
        state[curr] = 1;

        for(int next : graph.get(curr)){
            if(state[next] == 1 || (state[next] == 0 && hasCycle(next, graph, state))) return true;
        }

        state[curr] = 2;
        res[idx--] = curr;
        return false;
    }
}
