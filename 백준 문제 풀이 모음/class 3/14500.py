# import sys

# n, m = map(int, sys.stdin.readline().split())

# graph = []

# for i in range(n) :
#     tmp = list(map(int, sys.stdin.readline().split()))
#     graph.append(tmp)


# from collections import deque

# def bfs(a, b, cost) :
#     visited = []
#     for i in range(n) :
#         tmp = [False] * m
#         visited.append(tmp)
#     visited[a][b] = True

#     dx = [1, -1, 0, 0]
#     dy = [0, 0, 1, -1]

#     queue = deque()
#     queue.append([(a, b, cost)])

#     count = 0
    
#     while queue :


#         node = queue.popleft()
#         if count == 3 :
#             taa = []
#             for maxmax in node :
#                 taa.append(maxmax[2])
            
#             result =  graph[a][b]

#             return max(taa)
#             break

#         count_list = []
#         for z in range(len(node)) :
#             x, y, costcost = node[z][0], node[z][1], node[z][2]
#             visited[x][y] = True
#             for i in range(4) :
#                 ax = dx[i] + x
#                 ay = dy[i] + y

#                 if ax <0 or ax >= n or ay < 0 or ay >= m :
#                     continue
                
#                 if visited[ax][ay] == True :
#                     continue
                
#                 if visited[ax][ay] == False :
                    
#                     count_list.append((ax, ay, costcost + graph[ax][ay]))
        
#         queue.append(count_list)
#         count += 1


# def block(r, c, total) :
#     make_block = 0
#     dr = [-1, 0, 1, 0]
#     dc = [0, 1, 0, -1]

#     block_list = []
#     for i in range(4) :
#         nr = r +dr[i]
#         nc = c +dc[i]
#         if 0 <= nr < n and 0 <= nc < m :
#             make_block += 1
#             total += graph[nr][nc]
#         if make_block == 3 :
#             block_list.append(total)
#             total -= graph[nr][nc]
#         if make_block == 4:
#             for i in range(4) :
#                 nr = r + dr[i]
#                 nc = c + dc[i]
                
#                 block_list.append(total)

    
#     if len(block_list)== 0 :
#         return 0
#     else :
#         return max(block_list)


# cost = []
# for i in range(n) :
#     for j in range(m) :
#         tmp = bfs(i, j, graph[i][j])
#         total = block(i, j, graph[i][j])
        
#         cost.append(max([tmp, total]))



# print(max(cost))


import sys; input = sys.stdin.readline
def dfs(r, c, idx, total):
    global ans
    if idx == 3:
        if total > ans :
            ans = total
    else :
        for i in range(4) :
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <=nc < M :
                if visit[nr][nc] == 0:
                    visit[nr][nc] = 1
                    dfs(nr, nc, idx + 1, total + arr[nr][nc])
                    visit[nr][nc] = 0

def block(r, c, total):
    global ans
    make_block = 0
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < N and 0 <= nc < M:
            make_block += 1
            total += arr[nr][nc]

    if make_block == 3:
        if total > ans:
            ans = total

    if make_block == 4:
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            total -= arr[nr][nc]
            if total > ans:
                ans = total
            total += arr[nr][nc]

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visit = [([0] * M) for _ in range(N)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
ans = 0

for r in range(N):
    for c in range(M):
        visit[r][c] = 1
        dfs(r, c, 0, arr[r][c])
        block(r, c, arr[r][c])
        visit[r][c] = 0

print(ans)