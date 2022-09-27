import sys

input = sys.stdin.readline

n, m = map(int, input().split())

lis = list(range(1, n+1))
from itertools import combinations_with_replacement

for cwr in combinations_with_replacement(lis, m) :
    cwr = str(cwr).replace('(', '').replace(')', '').replace(',', '')
    print(cwr)
