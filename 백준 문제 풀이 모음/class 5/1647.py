import sys
input = sys.stdin.readline

N, M = map(int, input().split())

edge = []
parent = list(range(N+1))


for _ in range(M) :
    a,b,w = map(int, input().split())
    edge.append((w, a, b))

edge.sort(key = lambda x: x[0])

sum = 0

def union(a, b) :
    a = find(a)
    b = find(b)

    if a < b :
        parent[b] = a
    else :
        parent[a] = b

def find(x) :
    if x == parent[x] :
        return x
    
    parent[x] = find(parent[x])
    return parent[x]

big = -10000000
for w, a, b in edge :
    if find(a) != find(b) :
        union(a, b)
        sum += w
        if big <=  w :
            big = w 
print(sum - big)