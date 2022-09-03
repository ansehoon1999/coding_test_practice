import sys
from collections import deque

n, k = map(int, input().split())

q = deque()
q.append(n)
vis = [-1] * 2000001
vis[n] = 0

while q :
    x = q.popleft()
    if x == k :
        print(vis[x])
        sys.exit()

    if x * 2 <= 200000 and vis[x*2] == -1 :
        vis[x *2 ] = vis[x]
        q.appendleft(x*2)
    
    if x-1 >= 0 and vis[x-1] == -1 :
        vis[x-1] = vis[x] + 1
        q.append(x-1)
    
    if x+1 <= 200000 and vis[x+1] == - 1 :
        vis[x+1] = vis[x] + 1
        q.append(x+1)

