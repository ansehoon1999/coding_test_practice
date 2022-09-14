import sys
from collections import deque
N = int(sys.stdin.readline())
graph = []

for _ in range(N) :
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

def dfs(i, j) :
    count = 0
    queue = deque()
    queue.append((i, j))

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while queue :
        # for i in range(N) :
        #     for j in range(N) :
        #         print(graph[i][j], end = ' ')
        #     print()
        # print('---------')
        x, y = queue.popleft()
        graph[x][y] = 0
        count += 1
        for i in range(4) :
            nx = dx[i] + x
            ny = dy[i] + y
            
            if nx < 0 or nx >= N or ny < 0 or ny >= N :
                continue

            if graph[nx][ny] == 0 :
                continue

            if graph[nx][ny] == 1 :
                if (nx, ny) not in queue :
                    queue.append((nx, ny))
                
    return count

count = 0
count_list = []
for i in range(N) :
    for j in range(N) :
        if graph[i][j] == 1 :
            count += 1   
            count_list.append(dfs(i, j))


print(count)
for i in sorted(count_list) :
    print(i)




