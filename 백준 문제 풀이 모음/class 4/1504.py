import sys, heapq
input = sys.stdin.readline
INF = float('inf')
N, E = map(int, input().split())
graph = [[] for i in range(N + 1)] 

for i in range(E) :
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

start, end = map(int, input().split())


def dijkstra(start) :
    distance = [INF ] * (N+1)
    distance[start] = 0
    heap = []
    heapq.heappush(heap, (0, start))

    while heap :
        now_cost, now_node = heapq.heappop(heap)
        
        if distance[now_node] < now_cost :
            continue

        for new_cost, new_node in graph[now_node] :
            new_cost = new_cost + now_cost
            if distance[new_node] > new_cost :
                distance[new_node] = new_cost
                heapq.heappush(heap, (new_cost, new_node))
        
    return distance

arr1 = dijkstra(1)
arr2 = dijkstra(start)
arr3 = dijkstra(end)

first_arr = arr1[start] + arr2[end] + arr3[N]
second_arr = arr1[end] + arr3[start] + arr2[N]
min_arr = min(first_arr, second_arr)
if min_arr >= INF :
    print(-1)
else :
    print(min_arr)

