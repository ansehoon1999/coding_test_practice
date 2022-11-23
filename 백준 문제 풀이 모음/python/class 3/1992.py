import sys

N = int(sys.stdin.readline())

tree =[]
for _ in range(N) :
    tmp = list(sys.stdin.readline().rstrip())
    tree.append(tmp)


def quad (y, x, n) :
    count = 0
    for i in range(y, y + n) :
        for j in range(x, x + n) :
            count += int(tree[i][j])
    
    if count == 0 :
        print('0', end='')
    elif count == n * n :
        print('1', end='')
    else :
        print('(', end="")
        quad(y, x, n//2)
        quad(y, x + n//2, n//2)   
        quad(y + n//2, x, n//2)
        quad(y + n//2, x + n//2, n//2)          
        print(')', end="")

quad(0,0,N)
