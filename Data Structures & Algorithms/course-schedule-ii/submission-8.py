class Solution:
    def findOrder(self, n: int, req: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(n)]
        self.res = []
        for r in req:
            graph[r[1]].append(r[0])

        visited = [0] * n

        for i in range(n):
            if visited[i] == 0 and self.hasCycle(i, graph, visited):
                return []

        return self.res[:: -1]

    def hasCycle(self, node: int, graph: List[List[int]], visited: List[int]) -> bool:
        visited[node] = 1

        for next in graph[node]:
            if visited[next] == 1:
                return True
            if visited[next] == 0 and self.hasCycle(next, graph, visited):
                return True

        visited[node] = 2
        self.res.append(node)
        return False