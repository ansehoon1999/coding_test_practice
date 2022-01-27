
import sys

read = sys.stdin.readline
n, k = map(int, read().split())

cache = [0] * (k+1)

for _ in range(n) :
    w, v = map(int, read().split())

    for j in range(k, w-1, -1) :
        cache[j] = max(cache[j], cache[j-w] + v)

print(cache[-1])
