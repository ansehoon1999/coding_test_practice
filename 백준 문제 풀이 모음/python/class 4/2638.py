import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

# for i in range(n) :
#     for j in range(m) :
#         print(graph[i][j], end= " ")
#     print()

from collections import deque
import copy

dy = [1,-1,0,0]
dx = [0,0,1,-1]

def bfs(_graph) :
    #_graph[0][0] = 0
    queue = deque()
    queue.append((0,0))
    while queue :
        node_y, node_x = queue.popleft()

        for ii in range(4) :
            ay = node_y + dy[ii]
            ax = node_x + dx[ii]

            if ay < 0 or ay >= n or ax < 0 or ax >= m :
                continue

            if _graph[ay][ax] == 0 :
                _graph[ay][ax] = -1 

                queue.append((ay, ax))



def dfs (idx) :
    tmp_graph = copy.deepcopy(graph) 
    bfs(tmp_graph)

    # print('tmp_graph=====================')
    # for i in range(n) :
    #     for j in range(m) :
    #         print(tmp_graph[i][j], end= " ")
    #     print()
    # print('==============================')

    # print('graph=====================')
    # for i in range(n) :
    #     for j in range(m) :
    #         print(graph[i][j], end= " ")
    #     print()
    # print('==============================')

    total = 0
    for i in range(n) :
        for j in range(m) :
            if tmp_graph[i][j] == 1 :
                count = 0

                for k in range(4) :
                    by = i+dy[k]
                    bx = j+dx[k]

                    if tmp_graph[by][bx] == -1 :
                        count += 1
                
                if count >= 2 :
                    graph[i][j] = 0
            elif tmp_graph[i][j] == -1 :
                total += 1
    if total == n * m :
        print(idx)
        return
    dfs(idx+1)

dfs(0)

