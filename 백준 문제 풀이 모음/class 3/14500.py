import sys

n, m = map(int, sys.stdin.readline().split())

graph = []

for i in range(n) :
    tmp = list(map(int, sys.stdin.readline().split()))
    graph.append(tmp)

print('------------------------')
for i in range(n) :
    for j in range(m) :
        print(graph[i][j], end = ' ')
    print()
print('------------------------')

from collections import deque

def bfs(a, b, cost) :
    visited = []
    for i in range(n) :
        tmp = [False] * m
        visited.append(tmp)
    visited[a][b] = True

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    queue = deque()
    queue.append([(a, b, cost)])

    count = 0
    
    while queue :
        print('------------------------')
        for i in range(n) :
            for j in range(m) :
                print(visited[i][j], end = ' ')
            print()
        print('------------------------')
        print('count: ', count)
        print('queue: ', queue)
        print('------------------------')

       

        node = queue.popleft()
        if count == 3 :
            taa = []
            for maxmax in node :
                taa.append(maxmax[2])
            
            return max(taa)
            break
        print('node: ', node)

        count_list = []
        for z in range(len(node)) :
            x, y, costcost = node[z][0], node[z][1], node[z][2]
            visited[x][y] = True
            print('x, y, costcost: ', x, y, costcost)
            for i in range(4) :
                ax = dx[i] + x
                ay = dy[i] + y

                if ax <0 or ax >= n or ay < 0 or ay >= m :
                    continue
                
                if visited[ax][ay] == True :
                    continue
                
                if visited[ax][ay] == False :
                    
                    count_list.append((ax, ay, costcost + graph[ax][ay]))
        
        queue.append(count_list)
        count += 1


cost = []
for i in range(n) :
    for j in range(m) :
        tmp = bfs(i, j, graph[i][j])
        cost.append(tmp)

print(max(cost))