# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        if not root:
            return res

        queue = deque([root])

        while queue:
            size = len(queue)

            for i in range(size):
                curr = queue.popleft()
                if i == size - 1:
                    res.append(curr.val)
                
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)

        return res