

n, k = map(int, input().split())
ysps = []
result = []

for i in range(1, n+1) :
    ysps.append(i)

tmp = -1
for i in range(n) :
    
    tmp = tmp + k
    if tmp >= len(ysps) :
        tmp = tmp % len(ysps)

    result.append(ysps[tmp])
    ysps.remove(ysps[tmp])
    tmp = tmp -1 

print("<", end = "")
for i in range(len(result)) :
    if i == len(result)-1 :
        print(result[i], end="")
    else :
        print(result[i], end=", ")
print(">")


