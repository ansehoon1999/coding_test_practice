import sys

n = int(sys.stdin.readline())

d = {}
d[1] = 1
d[2] = 2
d[3] = 4

def cal(x) :
    if x == 1 :
        return d[1]
    
    elif x == 2 :
        return d[2]
    
    elif x == 3 :
        return d[3]

    x = cal(x-1) + cal(x-2) + cal(x-3)

    return x

for i in range(n):
    x = int(sys.stdin.readline())

    print(cal(x))

