import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
a_count = [1] * len(a)

for i in range(1, n) :
    for j in range(i) :
        if a[i] > a[j] :
            a_count[i] = max(a_count[i], a_count[j] + 1)

print(max(a_count))





