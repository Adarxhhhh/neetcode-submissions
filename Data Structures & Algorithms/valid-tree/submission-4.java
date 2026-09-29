class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean [] visited = new boolean[n];

        if(hasCycle(0, -1, graph, visited)) return false;

        for(boolean v : visited){
            if(!v) return false;
        }

    return true;
    }

    public boolean hasCycle(int curr, int parent, List<List<Integer>> graph, boolean [] visited){
        visited[curr] = true;

        for(int next : graph.get(curr)){
            if(next == parent) continue;
            if(visited[next]) return true;

            hasCycle(next, curr, graph, visited);
        }

        return false;
    }
}
