import sys

n = int(sys.stdin.readline())

result = [0,0,0]

for i in range(n) :
    tmp = list(map(int, sys.stdin.readline().split()))

    x1 = min(result[1] + tmp[0], result[2] + tmp[0])
    x2 = min(result[0] + tmp[1], result[2] + tmp[1])
    x3 = min(result[0] + tmp[2], result[1] + tmp[2])

    result[0] = x1
    result[1] = x2
    result[2] = x3


print(min(result))

