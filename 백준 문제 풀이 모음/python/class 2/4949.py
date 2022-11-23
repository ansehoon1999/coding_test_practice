import sys

class Stack() :
    def __init__(self) :
        self.stack = []
    def push(self, data) :
        self.stack.append(data)
    def pop(self) :
        if self.isEmpty() == False :
            self.stack.pop()
    def isEmpty(self) :
        is_empty = False
        if len(self.stack) == 0 :
            is_empty = True
        return is_empty

while True :
    input = sys.stdin.readline().rstrip()
    if input == '.' :
        break
    tmp = list(input)
    stk = Stack()
    for i in tmp :
        
        if i == '[' or i == ']' or i == '(' or i == ')' :
            stk.push(i)
            if len(stk.stack) < 2 :
                continue
            if stk.stack[-2] == '[' and stk.stack[-1] == ']' :
                stk.stack.pop(-2)
                stk.stack.pop(-1)
            elif stk.stack[-2] == '(' and stk.stack[-1] == ')' :
                stk.stack.pop(-2)
                stk.stack.pop(-1)

    if len(stk.stack) == 0 :
        print('yes')
    else :
        print('no')