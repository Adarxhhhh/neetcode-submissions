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
    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;
    }

    public void invert(TreeNode node){
        if(node == null || (node.left == null && node.right == null)) return;

        TreeNode left = null;
        TreeNode right = null;

        if(node.left != null) left = node.left;
        if(node.right != null) right = node.right;

        node.left = right;
        node.right = left;

        invert(left);
        invert(right);
    }
}
