class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneMap = new HashMap<>();

        return dfs(node, cloneMap);
    }

    public Node dfs(Node node, Map<Node, Node> cloneMap){
        if(node == null) return null;

        if(cloneMap.containsKey(node)) return cloneMap.get(node);

        Node copy = new Node(node.val);
        cloneMap.put(node, copy);

        for(Node neighbor : node.neighbors){
            copy.neighbors.add(dfs(neighbor, cloneMap));
        }

        return copy;
    }
}