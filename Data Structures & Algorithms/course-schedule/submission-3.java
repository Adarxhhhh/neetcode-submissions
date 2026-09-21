class Solution {
    public boolean canFinish(int n, int[][] preReq) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] req : preReq){
            graph.get(req[1]).add(req[0]);
        }

        int [] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 1) return false;
            if(visited[i] == 0 && hasCycle(i, graph, visited)) return false;
        }

    return true;
    }

    public boolean hasCycle(int node, List<List<Integer>> graph, int [] visited){
        visited[node] = 1;

        for(int dep : graph.get(node)){
            if(visited[dep] == 1) return true;
            if(visited[dep] == 0 && hasCycle(dep, graph, visited))return true;
        }

        visited[node] = 2;
        return false;
    }
}
