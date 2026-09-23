class Solution {
    public boolean canFinish(int n, int[][] req) {
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
            if(state[i] == 0 && hasCycle(i, graph, state)) return false;
        }

    return true;
    }

    public boolean hasCycle(int curr, List<List<Integer>> graph, int [] visited){
        visited[curr] = 1;

        for(int next : graph.get(curr)){
            if(visited[next] == 1) return true;
            if(visited[next] == 0 && hasCycle(next, graph, visited)) return true;
        }

        visited[curr] = 2;
        return false;
    }
}
