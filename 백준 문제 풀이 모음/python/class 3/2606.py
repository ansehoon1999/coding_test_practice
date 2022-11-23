import sys

x = int(sys.stdin.readline())
y = int(sys.stdin.readline())

dic = {}

def dfs(start, dic) :
    for i in dic[start] :
        if i not in visited :
            visited.append(i)
            dfs(i, dic)

for i in range(x):
    dic[i+1] = set()

for j in range(y) :
    a, b = map(int, sys.stdin.readline().split())
    dic[a].add(b)
    dic[b].add(a)

visited = []
dfs(1, dic)

print(len(visited)-1)