import sys

from itertools import combinations_with_replacement

input = sys.stdin.readline

n, m = map(int, input().split())

x = list(map(int, input().split()))
x.sort()
for cwr in combinations_with_replacement(x, m) :
    cwr = str(cwr).replace('(', '').replace(')', '').replace(',', '')
    print(cwr)