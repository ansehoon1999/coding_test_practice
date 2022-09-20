import sys

n = int(sys.stdin.readline())
graph = []

for i in range(n) :
    tmp = list(map(int, sys.stdin.readline().split()))
    graph.append(tmp)

for i in range(n) :
    for j in range(n) :
        if graph[i][j] == 9 :
            graph[i][j] = 0
            shark = (i, j)
            break

shark_size = 2
total = 0
from collections import deque
def dfs(x, y) :
    global shark
    global shark_size
    global graph
    global n
    global total
    tmp_graph = []
    for i in range(n) :
        tmp_graph.append([0] * n)

    dx = [-1, 0, 0, 1]
    dy = [0, -1, 1, 0]

    queue = deque()
    queue.append([(x, y)])

    while queue :
        aaa = False
        for i in range(n) :
            for j in range(n) :
                if 0 < graph[i][j] < shark_size :
                    aaa = True 
                    break
            if aaa :
                break
        if aaa == False :
            break
        
        print(queue)
        for i in range(n) :
            for j in range(n) :
                print(tmp_graph[i][j], end= ' ')
            print()
        
        node = queue.popleft()
        tmplist = []
        for i in range(len(node)) :
            if graph[node[i][0]][node[i][1]] < shark_size and graph[node[i][0]][node[i][1]] != 0 and graph[node[i][0]][node[i][1]] != 9 :
                graph[node[i][0]][node[i][1]] = 0
                shark = (node[i][0], node[i][1])
                
                return 'okay'

            tmp_graph[node[i][0]][node[i][1]] = 1

            for j in range(4) :
                ax = node[i][0] + dx[j]
                ay = node[i][1] + dy[j]

                if ax < 0 or ax >= n or ay < 0 or ay >= n :
                    continue

                if tmp_graph[ax][ay] == 1 or graph[ax][ay] > shark_size:
                    continue
                
                if (ax, ay) not in tmplist :
                    tmplist.append((ax, ay))
        tmplist.sort(key=lambda x:x[0])            
        queue.append(tmplist)
        total += 1
    return 'no'
count = 0

while True :
    print('-----------------')
    for i in range(n) :
        for j in range(n) :
            print(graph[i][j], end = ' ')
        print()
    print('-----------------') 
    print('shark_size: ', shark_size)
    print('count: ', count)
    print('total_length: ', total)
    print('-----------------')    

    x = dfs(shark[0], shark[1])
    if x == 'okay' :
        count += 1
    elif x == 'no' :
        break

    if shark_size == count :
        count = 0
        shark_size += 1


print(total)

