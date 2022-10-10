n = int(input())

graph = [["*"] * n for i in range(n)]

for i in range(1, n+1) :
    for j in range(0, i-1) :
        graph[i-1][j] = " "

for i in graph :
    print("".join(i))

