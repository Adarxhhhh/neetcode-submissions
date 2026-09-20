class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean [] visited = new boolean[n];
        int components = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                components++;
                dfs(visited, graph, i);
            }
        }
    return components;
    }

    public void dfs(boolean [] visited, List<List<Integer>> graph, int idx){
        visited[idx] = true;

        for(int neighbor : graph.get(idx)){
            if(!visited[neighbor]){
                dfs(visited, graph, neighbor);
            }
        }
    }
}
