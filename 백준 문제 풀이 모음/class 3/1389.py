
# graph = {}
# N, M = map(int, sys.stdin.readline().split())
# for _ in range(M) :
#     x, y = map(int, sys.stdin.readline().split())
#     if x not in graph :
#         graph[x] = [y]
#     else :
#         graph[x].append(y)

#     if y not in graph :
#         graph[y] = [x]
#     else : 
#         graph[y].append(x)

#  graph = {
#      1 : [3, 4],
#      2 : [3], 
#      3 : [1,2,4],
#      4 : [1,3,5],
#      5 : [4]
#  }
import sys
from collections import deque

# def bfs(graph, start, distances) :
#     queue = deque([start])
#     visited_nodes = [start]
    
#     while queue :
#         node = queue.popleft()
#         for adj_node in graph[node] :
#             if adj_node not in visited_nodes :
#                 visited_nodes.append(adj_node)
#                 queue.append(adj_node)
#                 distances[adj_node] = distances[node] + 1

#     return visited_nodes, distances

# min_num = 0
# min_cost = 1000000
# for i in range(1, N+1) :
    
#     distance_dict = dict.fromkeys(graph.keys(), 0)
#     tmp1, tmp2 = bfs(graph, i, distance_dict)
#     count = 0
#     for x, y in tmp2.items() :
#         count += y
#     if min_cost > count :
#         min_cost = count
#         min_num = i
# print(min_num)

graph = {
    'A': ['B', 'F', 'I'],
    'B': ['A', 'E', 'C'],
    'C': ['B', 'E', 'D'],
    'D': ['C', 'G', 'H'],
    'E': ['B', 'C', 'G'],
    'F': ['A', 'G'],
    'G': ['E', 'F', 'D'],
    'H': ['D'],
    'I': ['A']
}

def bfs(graph, start) :
    visited_nodes = []
    adjacency_nodes = deque([start])

    while adjacency_nodes :
        node = adjacency_nodes.popleft()
        if node not in visited_nodes :
            visited_nodes.append(node)
            adjacency_nodes.extend(graph[node])

print(bfs(graph, 'A'))