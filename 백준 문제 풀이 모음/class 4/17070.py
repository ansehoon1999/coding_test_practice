import sys
input = sys.stdin.readline
n = int(input())

graph = [list(map(int, input().split())) for _ in range(n)]
graph[0][0] = -1
graph[0][1] = -1

from collections import deque
def bfs() :

    queue = deque()    
    queue.append((0,1))

    while queue :
        node_x, node_y = queue.popleft()

        


for i in range(n) :
    for j in range(n) :
        print(graph[i][j], end= " ")
    print()