import sys

N = int(sys.stdin.readline())

stair = []
for _ in range(N+1) :
    stair.append([0,0])

for i in range(1, N+1) :
    tmp = int(sys.stdin.readline())
    if i == 1 :
        stair[1][0] = tmp
    else :
        stair[i][0] = tmp + max(stair[i-2])
        stair[i][1] = tmp + stair[i-1][0]
    
print(max(stair[-1]))

