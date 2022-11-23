import sys
input = sys.stdin.readline

n = int(input())

planet = []
for i in range(n) :
    x, y, z = list(map(int, input().split()))
    planet.append((x, y, z, i))

edges = []
for i in range(3) :
    planet.sort(key = lambda x: x[i])
    for j in range(1, n) :
        edges.append((abs(planet[j-1][i] - planet[j][i]), planet[j-1][3], planet[j][3]))

edges.sort()


parents = list(range(n))
def union(a, b) :
    a = find(a)
    b = find(b)

    if a < b :
        parents[b] = a
    else :
        parents[a] = b


def find(x) :
    if x == parents[x] :
        return x
    
    parents[x] = find(parents[x])
    return parents[x]

result = 0

for cost, x, y in edges :
    if find(x) != find(y) :
        union(x, y)
        result+= cost

print(result)