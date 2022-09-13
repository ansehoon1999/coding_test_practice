import sys
N, M = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().rstrip().split()))

for x in range(1, len(num)) :
    num[x] += num[x-1]



for _ in range(M) :
    i, j = map(int, sys.stdin.readline().split())
    count = num[j] - num[i]

    print(count)