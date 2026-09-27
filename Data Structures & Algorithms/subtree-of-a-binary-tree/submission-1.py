# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root == None and subRoot == None:
            return True
        if root == None or subRoot == None:
            return False

        if root.val == subRoot.val and self.sameTree(root, subRoot):
            return True

        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def sameTree(self, node: Optional[TreeNode], subNode: Optional[TreeNode]) -> bool:
        if node == None and subNode == None:
            return True
        if node == None or subNode == None:
            return False
        
        if node.val != subNode.val:
            return False

        return self.sameTree(node.left, subNode.left) and self.sameTree(node.right, subNode.right)
        