class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        boolean [] visited = new boolean[n];
        int components = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                components++;
                traverse(i, graph, visited);
            }
        }

        return components;
    }

    public void traverse(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;

        for(int next : graph.get(node)){
            if(!visited[next]) traverse(next, graph, visited);
        }
    }
}
