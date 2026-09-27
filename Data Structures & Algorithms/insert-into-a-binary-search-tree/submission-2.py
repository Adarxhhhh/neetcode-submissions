# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        prev = TreeNode(-1)

        if root == None:
            return TreeNode(val)
            
        self.insertNode(root, prev, val)

        return root
    
    def insertNode(self, node: Optional[TreeNode], prev: Optional[TreeNode], val: int):
        if node == None:
            if val < prev.val:
                prev.left = TreeNode(val)
            else:
                prev.right = TreeNode(val)

            return

        if val < node.val:
            return self.insertNode(node.left, node, val)
        else:
            return self.insertNode(node.right, node, val)
        