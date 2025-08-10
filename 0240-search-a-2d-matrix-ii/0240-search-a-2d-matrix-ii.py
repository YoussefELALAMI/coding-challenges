class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False

        def recursiveSearch(left, right, up, down):
            if left > right or down < up:
                return False
            if target < matrix[up][left] or target > matrix[down][right]:
                return False
            mid = left + (right - left) // 2
            row = up
            while row <= down and matrix[row][mid] <= target:
                if target == matrix[row][mid]:
                    return True
                row += 1
            return recursiveSearch(left, mid - 1, row, down) or recursiveSearch(
                mid + 1, right, up, row - 1
            )

        return recursiveSearch(0, len(matrix[0]) - 1, 0, len(matrix) - 1)
