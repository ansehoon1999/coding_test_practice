import sys

N, K = map(int, sys.stdin.readline().split())

coin = [0]
for i in range(N) :
    
    coin.append(int(sys.stdin.readline()))

count = 0
for i in range(len(coin)-1, 0, -1) :
    
    if K // coin[i] == 0 :
        continue
    
    if K == 0 :
        break
    count += (K // coin[i])
    K = K % coin[i]

print(count)


