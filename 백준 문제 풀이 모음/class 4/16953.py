import sys

input = sys.stdin.readline
from collections import deque

a, b = map(int, input().split())


def dfs(x) :

    queue = deque()
    queue.append([x])

    
    count = 0
    state = False
    while queue :
    
        node = queue.popleft()

        if len(node) == 0 :
            print(-1)
            break    
        if state :
            print(count+1)
            break

        tmp = []
        for i in node :
            if i* 2 < b :
                tmp.append(i * 2)
            elif i * 2 == b :
                tmp.append(i * 2)
                state = True

            if i* 10 + 1 <b :
                tmp.append(i * 10 + 1)
            elif i * 10 + 1 == b :
                tmp.append(i * 10 + 1)
                state = True
        queue.append(tmp)
        count += 1

dfs(a)
