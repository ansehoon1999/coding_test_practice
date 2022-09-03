
import sys

INF = 1000000000
input1 = int(sys.stdin.readline())
input2 = int(sys.stdin.readline())

result = [[INF for i in range(input1)] for j in range(input1)]


for i in range(input2) :
    a, b, c  = map(int, sys.stdin.readline().split())

    if result[a-1][b-1] > c :
        result[a-1][b-1] = c

for k in range(input1) :
    for i in range(input1) :
        for j in range(input1) :
            if i!=j and result[i][j] > result[i][k] + result[k][j] :
                result[i][j] = result[i][k] + result[k][j]

for i in range(input1) :
    for j in range(input1) :
        if result[i][j] == 1000000000 :
            print(0, end = ' ')
        else :
            print(result[i][j], end= ' ')
    print()


