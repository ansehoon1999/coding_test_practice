import sys
input = sys.stdin.readline
n, m = map(int, input().split())

from collections import deque
graph = [-1] * 100001

def bfs (n) :
    queue = deque()
    queue.append([n])
    count = 0
    while queue :
        node = queue.popleft()
        for i in node :
            graph[i] = 1
        #print('node: ', node)

        if m in node :
            print(count)
            return node

        tmp = []
        for i in node :
            if 0 <= i-1 <= 100000 :
                if graph[i-1] != 1 :
                    tmp.append(i-1)
            if 0 <= i+1 <= 100000 :    
                if graph[i+1] != 1 :
                    tmp.append(i+1)
            if 0 <= 2*i <= 100000 :          
                if graph[2*i] != 1 :
                    tmp.append(2*i)

        count += 1        
        queue.append(tmp)

        
aaa = bfs(n)
total = 0
for i in range(len(aaa)) :
    if aaa[i] == m :
        total += 1
print(total)

