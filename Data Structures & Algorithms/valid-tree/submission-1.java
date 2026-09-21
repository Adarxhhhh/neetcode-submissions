class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean [] visited = new boolean[n];
        if(hasCycle(0, -1, graph, visited)) return false;

        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
    return true;
    }

    public boolean hasCycle(int curr, int parent, List<List<Integer>> graph, boolean [] visited){
        visited[curr] = true;

        for(int neighbor : graph.get(curr)){
            if(neighbor == parent) continue;
            if(visited[neighbor]) return true;
            if(hasCycle(neighbor, curr, graph, visited)) return true;
        }

        return false;
    }
}
