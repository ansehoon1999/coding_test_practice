import sys
input = sys.stdin.readline

n, m = map(int, input().split())

parent = list(range(n+1))
edge = []
for _ in range(m) :
    a, b = map(int, input().split())
    edge.append((a,b))


def union(a, b) :
    a = find(a)
    b = find(b)

    if a < b :
        parent[b] = a
    else :
        parent[a] = b


def find (x) :
    if x == parent[x] :
        return x
    
    parent[x] = find(parent[x])
    return parent[x]


count = 0

for a, b in edge :
    if find(a) != find(b) :
        union(a, b)
        count += 1
    else :
        print(count+1)
        break

if count == m :
    print(0)

