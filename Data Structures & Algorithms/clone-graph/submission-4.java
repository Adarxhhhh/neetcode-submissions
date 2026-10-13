/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneMap = new HashMap<>();

        return findClone(node, cloneMap);
    }

    public Node findClone(Node node, Map<Node, Node> cloneMap){
        if(node == null) return node;

        if(cloneMap.containsKey(node)) return cloneMap.get(node);

        Node clone = new Node(node.val);
        cloneMap.put(node, clone);

        for(Node next : node.neighbors){
            clone.neighbors.add(findClone(next, cloneMap));
        }

        return clone;
    }
}