/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cloneMap = new HashMap<>();
        cloneMap.put(null, null);
        Node cloneHead = new Node(-1);
        Node ptr = cloneHead;
        Node curr = head;

        while(curr != null){
            Node clone = new Node(curr.val);
            ptr.next = clone;
            cloneMap.put(curr, clone);
            ptr = ptr.next;
            curr = curr.next;
        }

        curr = head;
        ptr = cloneHead.next;

        while(curr != null){
            Node rand = cloneMap.get(curr.random);
            ptr.random = rand;
            curr = curr.next;
            ptr = ptr.next;
        }

        return cloneHead.next;
    }
}
