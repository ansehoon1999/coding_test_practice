import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n = int(input())

adj = []
for i in range(n+1) :
    adj.append([])


for i in range(n) :
    tmp = list(map(int, input().split()))

    for j in range(1, len(tmp)-1,2) :
        adj[tmp[0]].append((tmp[j], tmp[j+1]))

def dfs(x, result) :

    for a, b in adj[x] :
        if result[a] == -1 :
            result[a] = result[x] + b
            dfs(a, result)

result1 = [-1] *(n+1)
result1[1] = 0
dfs(1, result1)

temp = 0
index = 0

for i in range(1, len(result1)) :
    if temp < result1[i] :
        temp = result1[i]
        index= i

result2 = [-1] * (n+1)
result2[index] = 0
dfs(index, result2)

print(max(result2))

