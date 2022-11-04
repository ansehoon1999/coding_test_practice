import sys
import math
input = sys.stdin.readline

n = int(input())

stars = []
edges = []
parents = list(range(n+1))

for _ in range(n) :
    x, y = map(float, input().split())
    stars.append((x, y))

for i in range(n-1) :
    for j in range(i+1, n) :
        edges.append((math.sqrt((stars[i][0] - stars[j][0])**2 + (stars[i][1] - stars[j][1])**2), i, j)) 
edges.sort()
def union(a, b) :
    a = find(a)
    b = find(b)

    if a < b :
        parents[b] = a
    else :
        parents[a] = b        

def find (x) :
    if x == parents[x]  :
        return x
    
    parents[x] = find(parents[x])
    return parents[x]

sum = 0
for w, a, b in edges :
    if find(a) != find(b) :
        union(a, b)
        sum = sum + w

print(round(sum,2))