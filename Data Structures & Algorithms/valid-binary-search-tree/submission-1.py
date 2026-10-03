# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.checkValidity(root, float('-inf'), float('inf'))

    def checkValidity(self, node: Optional[TreeNode], min: int, max: int) -> bool:
        if not node:
            return True

        if node.val <= min or node.val >= max:
            return False

        return self.checkValidity(node.left, min, node.val) and self.checkValidity(node.right, node.val, max)