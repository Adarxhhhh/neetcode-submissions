class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        r = len(grid)
        c = len(grid[0])

        row_Serv = [0] * r
        col_Serv = [0] * c

        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    row_Serv[i] += 1
                    col_Serv[j] += 1

        
        servers = 0

        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    if row_Serv[i] > 1 or col_Serv[j] > 1:
                        servers += 1

        
        return servers