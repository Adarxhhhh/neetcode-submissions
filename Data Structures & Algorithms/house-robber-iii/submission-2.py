# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode]) -> list[int]:
            if not node:
                return (0, 0)

            rob_left, skip_left = dfs(node.left)
            rob_right, skip_right = dfs(node.right)

            rob_curr = node.val + skip_left + skip_right
            skip_curr = max(rob_left, skip_left) + max(rob_right, skip_right)

            return (rob_curr, skip_curr)

    
        return max(dfs(root))