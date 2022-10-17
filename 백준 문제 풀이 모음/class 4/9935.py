import sys
input = sys.stdin.readline

class stack :
    def __init__(self) :
        self.top = []
    def __str__(self) :
        return str(self.top)
    def push(self, item) :
        self.top.append(item)
    def pop(self) :
        if not self.isEmpty() :
            return self.top.pop(-1)
        else :
            print('dd')
            exit()
    def isEmpty(self) :
        return len(self.top) == 0

arr = list(input().rstrip())
target = input().rstrip()
stk = stack()
for i in arr :
    stk.push(i)
    if ''.join(stk.top[-len(target):]) == target :
        for _ in range(len(target)) :
            stk.pop()

if stk.top :
    print(''.join(stk.top))
else :
    print('FRULA') 
