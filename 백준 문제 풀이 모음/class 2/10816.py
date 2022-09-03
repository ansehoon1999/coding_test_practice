import sys
from collections import Counter

n = int(input())
nnums = Counter(sys.stdin.readline().strip().split(' '))

m = int(input())
mnums = sys.stdin.readline().strip().split(' ')

count = []

for i in mnums :    
    count.append(nnums[i])

print(' '.join(map(str, count)))
