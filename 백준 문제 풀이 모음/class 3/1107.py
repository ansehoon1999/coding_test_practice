import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
if M != 0 :
    x = list(map(int, sys.stdin.readline().rstrip().split()))
else :
    x = []
new = []
for i in range(0,10,1) :
    if i not in x :
        new.append(str(i))

def product(arr,r):
    for i in range(len(arr)):
        if r == 1:
            yield arr[i]
        else:
            for next in product(arr,r-1):
                yield arr[i] + next

tmp = []
for i in range(1, 7) :
    for pro in product(new, i) :
        tmp.append(int(pro))  

minmin = abs(N-100)
x = []
for i in tmp :
    count = len(str(i)) + abs(N-i)
    x.append([i, count])
    if minmin > count :
        minmin = count
print(minmin)
