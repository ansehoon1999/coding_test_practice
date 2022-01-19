
class stack() :
    def __init__(self) :
        self.stack = []

    def push (self, data) :
        self.stack.append(data)
    
    def pop (self) :
        self.stack.pop()

import sys
num = int(sys.stdin.readline())
l = []
stk = stack()

for i in range(num) :
    l.append(int(sys.stdin.readline()))

result = []
first = l[0]
#l은 수열
for i in range(1, first + 1, 1) :
    stk.push(i)
    result.append('+')



l.remove(l[0])

print(result)

print(l)