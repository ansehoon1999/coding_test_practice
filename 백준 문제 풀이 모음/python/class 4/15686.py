import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = []

for _ in range(n) :
    tmp = list(map(int, input().split()))
    graph.append(tmp)

house = []
chicken = []

for i in range(n) :
    for j in range(n) :
        if graph[i][j] == 1 :
            house.append((i,j))
        elif graph[i][j] == 2 :
            chicken.append((i, j))
#print('house: ', house)
#print('chicken: ', chicken)
from itertools import combinations
min1 = 999999
for k in combinations(chicken, m) :
    count = 0
    for i in house :
        #print('house select: ', i)
        tmp_min = 99999
        for j in k :
            #print('chicken select: ', j)
            x = abs(i[0]-j[0]) + abs(i[1]-j[1])
            tmp_min = min(tmp_min, x)
        count += tmp_min

            
    if min1 > count :
        min1 = count
print(min1)


