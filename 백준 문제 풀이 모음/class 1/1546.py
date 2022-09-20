import sys

n = int(sys.stdin.readline())

x = list(map(int, sys.stdin.readline().split()))
maxmax= max(x)

print(sum(x)/n)