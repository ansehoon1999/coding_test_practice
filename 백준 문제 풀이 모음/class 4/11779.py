import sys, heapq
INF = sys.maxsize
input = sys.stdin.readline


n = int(input())
m = int(input())

graph = [[] for i in range(n+1)]


for i in range(m) :
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())
prev_node = [0] * (n+1)
def dijkstra(start) :
    
    distance = [INF] * (n + 1)
    distance[start] = 0
    heap = [(start, 0)]
    #print(distance)

    while heap :
        #print('heap: ', heap)
        now_node, now_cost = heapq.heappop(heap)
        #print('now_node: ' + str(now_node) + ' now_cost: ' + str(now_cost))
        if distance[now_node] < now_cost :
            continue

        for next_node, next_cost in graph[now_node] :
            next_cost = next_cost + now_cost
            #print('next_node: ' + str(next_node) + ' next_cost: ' + str(next_cost))

            if distance[next_node]  > next_cost :
                distance[next_node]  = next_cost
                prev_node[next_node] = now_node
                #print('distance: ', distance)
                #print('prev_node: ', prev_node)
                heapq.heappush(heap, (next_node, next_cost))
    return distance

print(dijkstra(start)[end])

path = [end]
now = end
while now != start :
    now = prev_node[now]
    path.append(now)
path.reverse()
print(len(path))
print(' '.join(map(str, path)))



