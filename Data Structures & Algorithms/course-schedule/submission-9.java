class Solution {
    public boolean canFinish(int n, int[][] req) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] r : req){
            graph.get(r[1]).add(r[0]);
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

        for(int next : graph.get(node)){
            if(visited[next] == 1) return true;
            if(visited[next] == 0 && hasCycle(next, graph, visited)) return true;
        }
    visited[node] = 2;
    return false;
    }
}
