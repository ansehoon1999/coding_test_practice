
class stack() :
    def __init__(self) :
        self.stack = []

    def push(self, data) :
        self.stack.append(data)
    
    def pop(self) :
        self.stack.pop()
    
    def sum(self) :
        return(sum(self.stack))
    
import sys
num = int(sys.stdin.readline())
stk = stack()

for i in range(num) :
    x = int(sys.stdin.readline())

    if x == 0 :
        stk.pop()
    
    else :
        stk.push(x)


print(stk.sum())

