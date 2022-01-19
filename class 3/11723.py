
import sys

m = int(sys.stdin.readline())

class Set() :
    def __init__ (self) :
        self.l =[]
    
    def add(self, x) :
        if x not in self.l :
            self.l.append(x)

    def remove(self, x) :
        if x in self.l :
            self.l.remove(x)

    def check(self, x) :
        if x in self.l :
            return 1
        else :  
            return 0

    def all (self) :
        self.l = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20']
    
    def toggle (self, x) :
        if x in self.l :
            self.l.remove(x)
        else :
            self.l.append(x)
    
    def empty (self) :
        self.l= []

    def show (self) :
        return self.l

model = Set()

for _ in range(m) :
    x = sys.stdin.readline().rstrip().split()

    if x[0] == 'add' :
        model.add(x[1])
    
    elif x[0] == 'remove' : 
        model.remove(x[1])
    
    elif x[0] == 'check' :
        print(model.check(x[1]))
        
    
    elif x[0] == 'toggle' :
        model.toggle(x[1])
    
    elif x[0] == 'all' :
        model.all()

    elif x[0] == 'empty' :
        model.empty()


