import sys, heapq
INF = sys.maxsize

input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[] for i in range(n+1)]

for i in range(m) :
    a, b, c,  = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())


def dijkstra(start) :
    distance = [INF] * (n+1)
    distance[start] = 0
    heap = [(0, start)]
    
    while heap :
        now_cost, node = heapq.heappop(heap)
        if distance[node] < now_cost :
            continue

        for next_node, next_cost in graph[node] :
            next_cost  = next_cost + now_cost

            if distance[next_node] > next_cost :
                heapq.heappush(heap, (next_cost, next_node))
                distance[next_node] = next_cost


    return distance




arr = dijkstra(start)
print(arr[end])