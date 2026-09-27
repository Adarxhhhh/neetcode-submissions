class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])

        l = 0
        r = m * n - 1

        while l <= r:
            mid = l + (r - l)//2
            ele = matrix[mid//n][mid%n]

            if ele == target:
                return True

            if ele < target:
                l = mid + 1
            else:
                r = mid - 1
        
        return False
        