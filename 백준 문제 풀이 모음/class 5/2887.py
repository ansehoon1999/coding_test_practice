import sys
input = sys.stdin.readline
N = int(input())

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


planet = []

for i in range(N) :
    x, y, z = list(map(int, input().split()))
    planet.append([x, y, z, i])

# print(planet)

edge = []
for j in range(3) :
    planet.sort(key = lambda x : x[j])
    for i in range(1, N) :
        edge.append((abs(planet[i-1][j] - planet[i][j]), planet[i-1][3], planet[i][3]))
    # print(edge)

edge.sort()
parents = list(range(N))
# print(parents)




result = 0
for cost, x, y in edge :
    # print(cost, (x, y))

    if find(x) != find(y) :
        union(x, y)
        result += cost

print(result)