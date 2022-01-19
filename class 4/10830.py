import sys

def mul(n, matrix1, matrix2) :
    result = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n) :
        for j in range(n) :
            for k in range(n) :
                result[i][j] += (matrix1[i][k] * matrix2[k][j]) % 1000000007
    
    return result

def devide(n, b, matrix) :
    if b == 1 :
        return matrix
    elif b == 2 :
        return mul(n, matrix, matrix)
    else :
        tmp = devide(n, b//2, matrix)
        if b %2 == 0 :
            return mul(n, tmp, tmp)
        else :
            return mul(n, mul(n, tmp, tmp), matrix)

input = int(sys.stdin.readline())
A = [[1,1], [1,0]]

s = 1000000007
result = devide(2, input, A)
print(result[0][1] % s)
