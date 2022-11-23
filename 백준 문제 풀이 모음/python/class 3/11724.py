import sys
sys.setrecursionlimit(10000)

n, m = map(int, sys.stdin.readline().split())

adj = []
count = 0
visited= [False] * (n+1)
for i in range(n+1) :
    adj.append([])

def dfs(v) :
    visited[v] = True
    for e in adj[v] :
        if not visited[e] :
            dfs(e)

for i in range(m) :
    x, y = map(int, sys.stdin.readline().split())
    adj[x].append(y)
    adj[y].append(x)


for i in range(1, n+1) :
    if not visited[i] :
        dfs(i)
        count +=1


print(count)
