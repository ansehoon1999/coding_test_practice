import sys

T = int(sys.stdin.readline())

def fun_R (array) :
    if len(array) == 0 :
        return []
    else :
        arr = array[::-1]
        return arr

def fun_D (array) :
    array.pop(0)
    return array


for _ in range(T) :
    p = list(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline())
    array = sys.stdin.readline().rstrip()
    
    count_R = 0
    for i in range(len(p)) :
        if p[i] == 'R' :
            
        
            count_R += 1
        
        else :
            array = fun_D(array)


