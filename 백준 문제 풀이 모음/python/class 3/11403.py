import sys

n = int(sys.stdin.readline())

graph = []
for i in range(n) :
    tmp = list(map(int, sys.stdin.readline().split()))
    graph.append(tmp)


for i in range(n) :
    for j in range(n) :
        if graph[i][j] == 0 :
            graph[i][j] = 1000000

for k in range(n) :
    for i in range(n) :
        for j in range(n) :
            if graph[i][j] > graph[i][k] + graph[k][j] :  
                graph[i][j] =  graph[i][k] + graph[k][j]  
                

for i in range(n) :
    for j in range(n) :
        if graph[i][j] == 1000000 :
            graph[i][j] = 0
        else :
            graph[i][j] = 1
        print(graph[i][j], end = ' ')
    print()

