import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())

def bfs() :
    q = deque()
    q.append(n)

    while q :
        x = q.popleft()
        if x == k  :
            print(dist[x])
            break

        for i in (x-1, x+1, x* 2 ) :
            if 0 <= i <= max and dist[i] == 0 :
                dist[i] = dist[x] + 1
                q.append(i)


max = 100000
dist = [0] * (max + 1)

bfs()