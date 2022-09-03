

import sys
from collections import deque

n = int(sys.stdin.readline())
l = deque()

for i in range(1, n+1) :
    l.append(i)

while True:
    if len(l) == 1 :
        break

    l.popleft()
    l.append(l.popleft())

print(l.pop())    
