
class queue() :
    def __init__(self) :
        self.que= []
    
    def push(self, data) :
        self.que.append(data)

    def pop(self) :
        pop_object = None

        if self.isEmpty() :
            pop_object = -1     
        else :
            pop_object = self.que[0]
            self.que = self.que[1:]

        return pop_object

    def size(self) :
        return len(self.que)

    def isEmpty(self) :
        is_empty = False 
        if len(self.que) == 0 :
            is_empty = True
        
        return is_empty


    def empty(self) :
        is_empty = None
        if len(self.que) == 0 :
            is_empty = 1
        else :
            is_empty = 0
        
        return is_empty

    def front(self) :
        front_object = None

        if self.isEmpty() :
            front_object = -1
        else :
            front_object = self.que[0]
        
        return front_object

    def back(self) :
        back_object = None

        if self.isEmpty() :
            back_object = -1
        else :
            back_object = self.que[-1]
        
        return back_object
    
import sys    

num = int(sys.stdin.readline())
q = queue()

for i in range(num) :
    x = sys.stdin.readline().split()

    if x[0] == 'push' :
        q.push(int(x[1]))
    
    elif x[0] == "pop" :
        print(q.pop())

    elif x[0] == "size" :
        print(q.size())
    
    elif x[0] == "empty" :
        print(q.empty())
    
    elif x[0] == "front" :
        print(q.front())
    
    elif x[0] == "back" :
        print(q.back())
        
    

        


