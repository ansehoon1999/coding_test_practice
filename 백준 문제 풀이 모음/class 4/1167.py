
import sys

n = int(sys.stdin.readline())
sys.setrecursionlimit(10 ** 9)

graph = [[] for _ in range(n+1)]
state = []

def dfs(x, wei) :
    for i in graph[x] :
        a, b = i
        if distance[a] == -1 and state[a] == False :
            state[a] = True
            distance[a] == wei+b
            dfs(a, wei+b)

            

for i in range(n) :
    state.append(False)
    tmp = list(map(int, sys.stdin.readline().split()))
    criterion = tmp[0]

    for j in range(1, len(tmp)-1, 2) :
        graph[criterion].append([tmp[j], tmp[j+1]])


distance = [-1] * (n + 1)
distance[1] = 0
state[1] = True

dfs(1, 0)

print(graph)






    
