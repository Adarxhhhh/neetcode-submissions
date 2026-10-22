class Solution {
    public boolean canFinish(int n, int[][] req) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int [] r : req){
            graph.get(r[1]).add(r[0]);
        }

        int [] visited = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0 && hasCycle(i, graph, visited)) return false;
        }

        return true;
    }

    public boolean hasCycle(int i, List<List<Integer>> graph, int [] visited){
        visited[i] = 1;

        for(int next : graph.get(i)){
            if(visited[next] == 1) return true;
            if(visited[next] == 0 && hasCycle(next, graph, visited)) return true;
        }

        visited[i] = 2;
        return false;
    }
}
