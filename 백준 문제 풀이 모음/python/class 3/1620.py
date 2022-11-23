
import sys
n, m = map(int, sys.stdin.readline().split())

l = []
dic = {}
for i in range(n) :
    x = sys.stdin.readline().rstrip()
    l.append(x)
    dic[x] = i+1

for i in range(m) :
    y = sys.stdin.readline().rstrip()

    if y.isdigit() :
        print(l[int(y) -1])
    else  :
        print(dic[y])

        
