
import sys
n, m = map(int, input().split())
x = sys.stdin.readline()
x = x.split(" ")

max_num = -1
for i in range(0, n-2, 1) :
    for j in range(i+1, n-1, 1) :
        for z in range(j+1, n, 1) :
            
            tmp = int(x[i]) + int(x[j]) + int(x[z])
            if max_num < tmp <= m :
                max_num = tmp

print(max_num)

