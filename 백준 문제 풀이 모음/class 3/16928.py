import sys

N, M = map(int, sys.stdin.readline().split())
dict = {}

for _ in range(N+M) :
    a, b = map(int, sys.stdin.readline().split())
    dict[a] = b

from collections import deque



def bfs (num) :
    queue = deque()
    queue.append([num])

    count = 0
    while queue :
        node = queue.popleft()
        count += 1


        if 100 in node :
            break

        tmp = []
        for i in range(len(node)) :
            for j in range(6) :
                if node[i] + j + 1 not in tmp :
                    if node[i] + j + 1 in dict :
                        if dict[node[i] + j + 1] not in tmp :
                            tmp.append(dict[node[i] + j + 1])
                    else :
                        tmp.append(node[i] + j + 1)
        queue.append(tmp)

    return count

print(bfs(1)-1)
        




