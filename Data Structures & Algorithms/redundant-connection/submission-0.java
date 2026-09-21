class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int [] parent = new int[n + 1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = findParent(parent, u);
            int rootV = findParent(parent, v);

            if(rootU == rootV){
                return edge;
            }

            parent[rootU] = rootV;
        }

    return new int[0];
    }

    public int findParent(int [] parent, int curr){
        if(parent[curr] == curr) return curr;
        return parent[curr] = findParent(parent, parent[curr]);
    }
}
