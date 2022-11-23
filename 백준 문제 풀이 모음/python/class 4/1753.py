import sys, heapq
input = sys.stdin.readline
INF = sys.maxsize
v, e = map(int, input().split())
start = int(input())

distance = [INF] * (v+1)
heap =  []
graph = [[] for i in range(v+1)] 


def dijkstra(start) :
    distance[start] = 0

    heapq.heappush(heap, (0, start))
    while heap :
        now_cost, now_node = heapq.heappop(heap)
        if distance[now_node] < now_cost :
            continue
        for new_cost, new_node in graph[now_node] :
            w = new_cost + now_cost
            if distance[new_node] > w :
                distance[new_node] = w
                heapq.heappush(heap, (w, new_node))

for _ in range(e) :
    a, b, c = map(int, input().split())
    graph[a].append((c,b))


dijkstra(start)
for i in range(1,v+1):
    print("INF" if distance[i] == INF else distance[i])
