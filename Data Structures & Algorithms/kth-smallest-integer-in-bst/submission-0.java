/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);

        return list.get(k - 1);
    }

    public void inOrder(TreeNode node, int k){
        if(node == null) return;

        inOrder(node.left, k);
        list.add(node.val);
        inOrder(node.right, k);
    }
}
