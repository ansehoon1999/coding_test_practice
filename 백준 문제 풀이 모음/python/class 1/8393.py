import sys

count = 0

n = int(sys.stdin.readline())

for i in range(1, n+1) :
    count += i

print(count)