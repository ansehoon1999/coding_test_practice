from itertools import combinations, permutations

import sys

n, m = map(int, sys.stdin.readline().split())

l = list(map(int, sys.stdin.readline().split(" ")))
l.sort()

perm = list(permutations(l, m))

for i in perm :
    for j in range(m) :
        print(i[j], end = " ")
    print()