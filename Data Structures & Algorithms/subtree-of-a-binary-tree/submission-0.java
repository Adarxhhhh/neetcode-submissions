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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val == subRoot.val && sameTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode node, TreeNode subNode){
        if(node == null && subNode == null) return true;
        if(node == null || subNode == null) return false;

        if(node.val != subNode.val) return false;

        return sameTree(node.left, subNode.left) && sameTree(node.right, subNode.right);
    }
}
