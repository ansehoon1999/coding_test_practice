import sys

M, N, H = map(int, sys.stdin.readline().split())
graph = []
tmp_1 = []
for _ in range(H) :
    for i in range(N) :
        tmp_1.append(list(map(int, sys.stdin.readline().split())))
    
    graph.append(tmp_1)
    tmp_1 = []


from collections import deque

count = 0
def bfs(queue) :
    global graph
    global count

    dx =[1, -1, 0, 0, 0, 0]
    dy =[0, 0, 1, -1, 0, 0]
    dz =[0, 0, 0, 0, 1, -1]

    

    while queue :
        node= queue.popleft()
        tmp = []
        for a in node :
            
            ax, ay, az = a
            
            for i in range(6) :
                x = ax + dx[i]
                y = ay + dy[i]
                z = az + dz[i]

                if x < 0 or x >= H or y < 0 or y >= N or z < 0  or z>= M:
                    continue

                if graph[x][y][z] == -1 or graph[x][y][z] == 1:
                    continue

                elif graph[x][y][z] == 0 :
                    tmp.append((x, y, z))
                    graph[x][y][z] = 1
        
        if len(tmp) != 0 :
            queue.append(tmp)

        count += 1

queue = deque()
tmp = []
for i in range(H):
    for j in range(N) :
        for k in range(M) :
            if graph[i][j][k] == 1:
                tmp.append((i, j, k))
queue.append(tmp)
bfs(queue)

state = False
for i in range(H):
    for j in range(N) :
        for k in range(M) :
            if graph[i][j][k] == 0:
                state = True
                break

        if state == True :
            break
    if state == True :
        break

if state == True :
    print(-1)
else :
    print(count-1)


