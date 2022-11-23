import sys
input = sys.stdin.readline

N, M = map(int, input().split())

innum = [0] * (N + 1)
graph = {}
for i in range(1, N+1) :
    graph[i] = []

for i in range(M) :
    A, B = map(int, input().split())
    innum[B] += 1
    graph[A].append(B)

# print(graph)
# print(innum)

heap = []
for i in range(1, N+1) :
    if innum[i] == 0 :
        heap.append(i)

result = []
while heap :
    node = heap.pop(0)
    result.append(str(node))
    for xxx in graph[node] :
        innum[xxx] -= 1
        if innum[xxx] == 0 :
            heap.append(xxx)


print(' '.join(result))


