
class deque() :
    def __init__(self) :
        self.deque= []
    
    def push_front(self, data) :
        self.deque.insert(0, data)

    def push_back(self, data) :
        self.deque.append(data)

    def pop_front(self) :
        pop_object = None

        if self.isEmpty() :
            pop_object = -1     
        else :
            pop_object = self.deque[0]
            self.deque = self.deque[1:]

        return pop_object

    def pop_back(self) :
        pop_object = None

        if self.isEmpty() :
            pop_object = -1     
        else :
            pop_object = self.deque[-1]
            self.deque.pop()

        return pop_object



    def size(self) :
        return len(self.deque)

    def isEmpty(self) :
        is_empty = False 
        if len(self.deque) == 0 :
            is_empty = True
        
        return is_empty


    def empty(self) :
        is_empty = None
        if len(self.deque) == 0 :
            is_empty = 1
        else :
            is_empty = 0
        
        return is_empty

    def front(self) :
        front_object = None

        if self.isEmpty() :
            front_object = -1
        else :
            front_object = self.deque[0]
        
        return front_object

    def back(self) :
        back_object = None

        if self.isEmpty() :
            back_object = -1
        else :
            back_object = self.deque[-1]
        
        return back_object
    
import sys    

num = int(sys.stdin.readline())
q = deque()

for i in range(num) :
    x = sys.stdin.readline().split()

    if x[0] == 'push_back' :
        q.push_back(int(x[1]))
    
    elif x[0] == 'push_front' :
        q.push_front(int(x[1]))

    elif x[0] == "pop_front" :
        print(q.pop_front())

    elif x[0] == "pop_back" :
        print(q.pop_back())

    elif x[0] == "size" :
        print(q.size())
    
    elif x[0] == "empty" :
        print(q.empty())
    
    elif x[0] == "front" :
        print(q.front())
    
    elif x[0] == "back" :
        print(q.back())
        
    

        


