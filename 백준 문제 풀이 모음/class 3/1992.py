import sys

N = int(sys.stdin.readline())

tree =[]
for _ in range(N) :
    tmp = list(sys.stdin.readline().rstrip())
    tree.append(tmp)
print(tree)


def quad (start1, start2, n) :
    count = 0
    for i in range(start1, start1 + n) :
        for j in range(start2, start2 + n) :
            count += int(tree[i][j])
    
    if count == 0 :
        return '0'
    elif count == n * n :
        return '1'
    else :
        quad(0, 0, n/2)
        quad(0, )            
