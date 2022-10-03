import sys, heapq
input = sys.stdin.readline
INF = sys.maxsize

n, m, r = map(int, input().split())
item = list(map(int, input().split()))
graph = [[] for i in range(n+1)]

for i in range(r) :
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

def dijkstra(start) :
    distance = [INF] * (n+1)
    distance[start] = 0
    heap = [(start, 0)]

    while heap :
        #print('heap: ', heap)
        now_node, now_cost = heapq.heappop(heap)
        for next_node, next_cost in graph[now_node] :
            #print('next node: ' + str(next_node) + ' next_cost: ', str(next_cost))
            next_cost = next_cost + now_cost
            if distance[next_node] > next_cost :
                distance[next_node] = next_cost
                #print('distance: ', distance)
                heapq.heappush(heap, (next_node, next_cost))
    return(distance)

cost_list = []
for i in range(1, n+1) :
    arr = dijkstra(i)
    #print('arr: ', arr)
    cost = 0
    for j in range(1, len(arr)) :
        if arr[j] <= m :
            cost += item[j-1] 
    
    #print('result cost: ' + str(cost))
    cost_list.append(cost)

print(max(cost_list))


