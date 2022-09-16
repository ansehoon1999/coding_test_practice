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
    if n == 0 :
        array = []
    else :
        array = array[1:-1].split(',')
    
    for i in p :
        if i == 'R' :
            array = fun_R(array)          
        elif i == 'D' :
            if n == 0 or len(array) == 0 :
                array = 'error'
                
                break
            else :
                array = fun_D(array)

    if array == 'error' :
        print('error')
    else :
        result = []
        for i in array :
            result.append(int(i))
        print(result)