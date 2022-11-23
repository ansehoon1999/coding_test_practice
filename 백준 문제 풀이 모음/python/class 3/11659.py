import sys
N, M = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().rstrip().split()))

for x in range(1, len(num)) :
    num[x] += num[x-1]


for _ in range(M) :
    i, j = map(int, sys.stdin.readline().split())
    if i == 1 :
        count = num[j-1] 
    elif i == j :
        count = num[j-1] - num[j-2]
    else :
        count = num[j-1] - num[i-2]

    print(count)