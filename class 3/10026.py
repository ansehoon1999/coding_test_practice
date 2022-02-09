import sys
sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

n = int(input())

count1 = 0
count2 = 0

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs(x, y) :
    visit[x][y] = True
    curr = graph[x][y]

    for k in range(4) :
        nx = x + dx[k]
        ny = y + dy[k]
        
        if (0 <= nx < n) and (0 <= ny < n ) :
            if visit[nx][ny] == False :    
                if curr == graph[nx][ny] :
                    dfs(nx, ny)

visit = [[False] * n  for _ in range(n)]

graph = []
for i in range(n) :
    tmp = list(input().rstrip())
    graph.append(tmp)


for i in range(n) : #세로
    for j in range(n) : #가로
        if visit[i][j] == False :
            dfs(i, j)
            count1 += 1

for i in range(n) :
    for j in range(n) :
        if graph[i][j] == 'R' :
            graph[i][j] = 'G'

visit = [[False] * n  for _ in range(n)]


for i in range(n) : #세로
    for j in range(n) : #가로
        if visit[i][j] == False :
            dfs(i, j)
            count2 += 1

print(count1, count2)