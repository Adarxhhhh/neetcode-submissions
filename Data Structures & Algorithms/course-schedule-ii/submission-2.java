class Solution {

    int [] res;
    int idx;

    public int[] findOrder(int n, int[][] preReq) {
        res = new int[n];
        idx = n - 1;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int [] req : preReq){
            graph.get(req[1]).add(req[0]);
        }

        int [] state = new int[n];

        for(int i = 0; i < n; i++){
            if(state[i] == 1 || (state[i] == 0 && hasCycle(i, graph, state))) return new int[]{};
        }

    return res;
    }

    public boolean hasCycle(int node, List<List<Integer>> graph, int [] state){
        state[node] = 1;

        for(int next : graph.get(node)){
            if(state[next] == 1) return true;
            if(state[next] == 0 && hasCycle(next, graph, state)) return true;
        }

        state[node] = 2;
        res[idx--] = node;
        return false;
    }
}
