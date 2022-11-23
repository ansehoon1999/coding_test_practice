import sys

graph = {}
N, M = map(int, sys.stdin.readline().split())
for _ in range(M) :
    x, y = map(int, sys.stdin.readline().split())
    if x not in graph :
        graph[x] = [y]
    else :
        graph[x].append(y)

    if y not in graph :
        graph[y] = [x]
    else : 
        graph[y].append(x)

# graph = {
#     1 : [3, 4],
#     2 : [3], 
#     3 : [1,2,4],
#     4 : [1,3,5],
#     5 : [4]
# }

from collections import deque



def bfs(graph, start, distances) :
    queue = deque([start])
    visited[start] = True

    while queue :
        node = queue.popleft()
        for i in graph[node] :
            if not visited[i] :
                queue.append(i)
                visited[i] = True
                distances[i] = distances[node] + 1

    return distances
min_num = 0
min_cost = 1000000
for i in range(1, N+1) :
    visited = [False] * (N+1)
    distance_dict = dict.fromkeys(graph.keys(), 0)
    tmp2 = bfs(graph, i, distance_dict)
    count = 0
    for x, y in tmp2.items() :
        count += y
    if min_cost > count :
        min_cost = count
        min_num = i
print(min_num)
# graph = [
#     [],
#     [2, 3],
#     [1, 8],
#     [1, 4, 5],
#     [3, 5],
#     [3, 4],
#     [7, 8],
#     [6, 8],
#     [2, 6, 7]
# ]

# visited = [False] * 9

# def bfs(graph, start, visited) :
#     queue = deque([start])
#     visited[start] = True

#     while queue :
#         node = queue.popleft()
#         print(node, end = ' ')
#         for i in graph[node] :
#             if not visited[i] :
#                 queue.append(i)
#                 visited[i] = True


# print(bfs(graph, 1, visited))