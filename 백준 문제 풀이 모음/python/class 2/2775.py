import sys

test_case = int(sys.stdin.readline())

for _ in range(test_case) :
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    
    ap = [[0] * n for _ in range(k+1) ]
    
    for i in range(k+1) :
        for j in range(n) :
            if i == 0 :
                ap[i][j] = j+1
            else :
                tmp = 0
                while True :
                    if tmp  == j + 1 :
                        break
                    ap[i][j] += ap[i-1][tmp]
                    tmp += 1
    
    print(ap[k][n-1])

