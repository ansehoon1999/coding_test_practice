import sys

n = int(sys.stdin.readline())

count = {1: 0 , 2: 1}

def make(n) :
    if n in count :
        return count[n]
    
    cnt =  1 + min (make(n//3) + n %3, make(n//2) + n % 2)
    count[n] = cnt
    return cnt
    
print(make(n))

