import sys

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
a_count = [1] * len(a)
before = list(range(n))
print(before)
for i in range(1, n) :
    tmp1 = []
    tmp2 = []
    maxx = -1
    idx = i
    for j in range(i) :
        
        
        if a[i] > a[j] :
            a_count[i] = max(a_count[i], a_count[j] + 1)
            if a[j] > maxx :
                maxx = a[j]
                idx = j
        
    before[i] = idx
    print(before)


curr = before.index(max(before))
print(curr)

result = []
while True :
    if before[curr] == curr :
        break
    
    result.append(a[curr])
    curr = before[curr]

    print(curr, result)

print(before)




print(max(a_count))





