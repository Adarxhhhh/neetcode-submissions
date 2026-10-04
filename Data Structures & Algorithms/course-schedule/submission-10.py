class Solution:
    def canFinish(self, n: int, req: List[List[int]]) -> bool:
        graph = [[] for _ in range(n)]

        for sub1, sub2 in req:
            graph[sub2].append(sub1)

        visited = [0] * n

        for i in range(n):
            if visited[i] == 1:
                return False
            if visited[i] == 0 and self.hasCycle(i, graph, visited):
                return False;

        return True


    def hasCycle(self, node: int, graph: List[List[int]], visited: List[int]):
        visited[node] = 1

        for next in graph[node]:
            if visited[next] == 1:
                return True
            if visited[next] == 0 and self.hasCycle(next, graph, visited):
                return True

        visited[node] = 2
        return False