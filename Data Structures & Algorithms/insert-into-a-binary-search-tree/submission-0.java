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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode prev = new TreeNode(-1);

        if(root == null) return new TreeNode(val);

        insertNode(root, prev, val);

        return root;
    }

    public void insertNode(TreeNode node, TreeNode prev, int val){
        if(node == null){
            if(val > prev.val){
                prev.right = new TreeNode(val);
            }else{
                prev.left = new TreeNode(val);
            }

        return;
        }

        if(val < node.val){
            insertNode(node.left, node, val);
        }else{
            insertNode(node.right, node, val);
        }
    }
}