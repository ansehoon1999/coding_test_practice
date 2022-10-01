# import sys
# input = sys.stdin.readline
# n, m, x = map(int, input().split())

# graph = []
# for i in range(n) :
#     tmp = []
#     for j in range(n) :
#         if i == j :
#             tmp.append(0)
#         else :
#             tmp.append(10000)
#     graph.append(tmp)
# for _ in range(m) :
#     a, b, c = map(int, input().split())
#     graph[a-1][b-1] = c

# for i in range(n) :
#     for j in range(n) :
#         if i == j :
#             graph[i][j] = 0


# for k in range(n) :
#     for i in range(n) :
#         for j in range(n) :
            
#             if graph[i][j] > graph[i][k] + graph[k][j] :
#                 graph[i][j] = graph[i][k] + graph[k][j]



# mm = -1
# for i in range(n) :
#     for j in range(n) :
#         if i == j :
#             continue
#         elif i < j :
#             graph[i][j] = graph[i][j] + graph[j][i]
#         if mm < graph[i][j] :
#             mm = graph[i][j]

# for i in range(n) :
#     for j in range(n) :
#         print(graph[i][j], end = ' ')
#     print()
# print(mm)


import sys, heapq
INF = sys.maxsize
input = sys.stdin.readline

def dijkstra(start_node) :
    distance = [INF] * (N+1)
    heap = []
    heapq.heappush(heap, [0, start_node])
    distance [start_node] = 0

    while heap :
        now_cost, node = heapq.heappop(heap)
        for next_cost, next_node in graph[node] :
            next_cost = next_cost + now_cost

            if next_cost < distance[next_node] :
                distance[next_node] = next_cost
                heapq.heappush(heap, [next_cost, next_node])
    return distance

N, M, X = map(int, input().split())

graph = [[] * (N+1) for _ in range(N+1)]


for i in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append([cost,end])

answer = [0] * (N+1)

for i in range(1, N+1) :
    arr = dijkstra(i)
    answer[i] += arr[X]
    arr2 = dijkstra(X)
    answer[i] += arr2[i]

print(max(answer))
