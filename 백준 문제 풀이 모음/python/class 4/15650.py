
import itertools

n, m = map(int, input().split())
l = []
for i in range(1, n+1, 1) :
    l.append(i)

ncr = itertools.combinations(l,m)



for i in list(ncr) :
    for j in range(m) :
        print(i[j], end = " ")

    print()

    
