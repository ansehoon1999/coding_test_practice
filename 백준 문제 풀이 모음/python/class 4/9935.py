import sys
input = sys.stdin.readline

class stack :
    def __init__(self) :
        self.top = []
    def push(self, data) :
        self.top.append(data)
    def pop(self) :
        self.top.pop(-1)

stk = stack()

arr = input().rstrip()
target = input().rstrip()
l = len(target)

for i in arr :
    stk.push(i)
    if ''.join(stk.top[- l :]) == target :
        for _ in range(l) :
            stk.pop()

if stk.top :
    print(''.join(stk.top))
else :
    print('FRULA')