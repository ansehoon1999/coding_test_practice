
class stack() :
    def __init__(self) :
        self.stack= []
    
    def push(self, data) :
        self.stack.append(data)

    def pop(self) :
        pop_object = None

        if self.isEmpty() :
            pop_object = -1     
        else :
            pop_object = self.stack.pop()
        
        return pop_object

    def size(self) :
        return len(self.stack)

    def isEmpty(self) :
        is_empty = False 
        if len(self.stack) == 0 :
            is_empty = True
        
        return is_empty


    def empty(self) :
        is_empty = None
        if len(self.stack) == 0 :
            is_empty = 1
        else :
            is_empty = 0
        
        return is_empty

    def top(self) :
        top_object = None

        if self.isEmpty() :
            top_object = -1
        else :
            top_object = self.stack[-1]
        
        return top_object
    
import sys    

num = int(sys.stdin.readline())
stk = stack()

for i in range(num) :
    x = sys.stdin.readline().split()

    if x[0] == 'push' :
        stk.push(int(x[1]))
    
    elif x[0] == "pop" :
        print(stk.pop())
    
    elif x[0] == "empty" :
        print(stk.empty())
    
    elif x[0] == "top" :
        print(stk.top())
        
    elif x[0] == "size" :
        print(stk.size())

        


