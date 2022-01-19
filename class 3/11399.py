import sys

n = sys.stdin.readline()
x = list(map(int, sys.stdin.readline().split(' ')))
x.sort()

num = 0
for i in range(len(x)):
    num = num + (x[i] * (len(x)-i))


print(num)
