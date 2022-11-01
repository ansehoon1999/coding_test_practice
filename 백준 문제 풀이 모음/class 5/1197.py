
# from sys import stdin

# read = stdin.readline
# V, S = map(int, read().split())

# edge = []
# for _ in range(S) :
#     a, b, w = map(int, read().split())
#     edge.append((w,a,b))

# edge.sort(key = lambda x : x[0])
# parent = list(range(V+1))
# sum = 0

# def union(a, b) :
#     a = find(a)
#     b = find(b)

#     if a < b :
#         parent[b] = a
#     else :
#         parent[a] = b


# def find(a) :
#     if a == parent[a] :
#         return a
#     parent[a] = find(parent[a])
#     return parent[a]

# for w, s, e  in edge :
#     if find(s) != find(e) :
#         union(s,e)
#         sum += w

# print(sum)

import heapq
import collections
import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m = map(int, input().split())
graph = collections.defaultdict(list)
visited = [0] * (n+1)

for i in range(m) :
    u, v, weight = map(int, input().split())
    graph[u].append([weight, u, v])
    graph[v].append([weight, v, u])

def prim(graph, start_node) :
    visited[start_node] = 1
    candidate = graph[start_node]
    heapq.heapify(candidate)
    total_weight = 0

    while candidate :
        weight, u, v = heapq.heappop(candidate)
        if visited[v] == 0 :
            visited[v] = 1
            total_weight += weight

            for edge in graph[v] :
                if visited[edge[2]] == 0 :
                    heapq.heappush(candidate, edge)
    return total_weight
print(prim(graph, 1))