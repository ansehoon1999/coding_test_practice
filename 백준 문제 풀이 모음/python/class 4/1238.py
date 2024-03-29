import sys, heapq
INF = sys.maxsize
input = sys.stdin.readline

def dijkstra(start_node) :
    distance =[INF] * (N+1) 
    distance[start_node] = 0
    heap = []

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
    answer[i] += arr[i]

print(max(answer))