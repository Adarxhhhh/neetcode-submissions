class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int [] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean [] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                components++;
                dfs(i, graph, visited);
            }
        }

    return components;
    }

    public void dfs(int node, List<List<Integer>> graph, boolean [] visited){
        visited[node] = true;

        for(int next : graph.get(node)){
            if(!visited[next]){
                dfs(next, graph, visited);
            }
        }
    }
}
