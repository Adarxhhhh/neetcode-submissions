# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if not root:
            return 0

        return 1 + self.findGoodNodes(root.left, root.val) + self.findGoodNodes(root.right, root.val)


    def findGoodNodes(self, node: TreeNode, greatest: int) -> int:
        if not node:
            return 0

        if node.val >= greatest:
            return 1 + self.findGoodNodes(node.left, node.val) + self.findGoodNodes(node.right, node.val)
        else:
            return self.findGoodNodes(node.left, greatest) + self.findGoodNodes(node.right, greatest)