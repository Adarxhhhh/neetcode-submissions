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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        return 1 + findGoodNodes(root.left, root.val) + findGoodNodes(root.right, root.val);
    }

    public int findGoodNodes(TreeNode node, int prevGr){
        if(node == null) return 0;

        if(node.val >= prevGr){
            return 1 + findGoodNodes(node.left, node.val) + findGoodNodes(node.right, node.val);
        }else{
            return findGoodNodes(node.left, prevGr) + findGoodNodes(node.right, prevGr);
        }
    }
}
