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
    public boolean isValidBST(TreeNode root) {
        return checkValidity(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValidity(TreeNode node, long minVal, long maxVal){
        if(node == null) return true;

        if(node.val <= minVal || node.val >= maxVal) return false;

        return checkValidity(node.left, minVal, (long)node.val) && checkValidity(node.right, (long)node.val, maxVal);
    }
}
