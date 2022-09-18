import sys

N = int(sys.stdin.readline())
count = 0

DP = [0] * (N+1)

k = 1
while k ** 2 <= N :
    DP[k ** 2] = 1
    k += 1

for i in range(1, N+1) :
    if DP[i] != 0 :
        continue
    j = 1
    while j* j <= i :
        if DP[i] == 0 :
            DP[i] = DP[j*j] + DP[i - j *j]
        else :
            DP[i] = min(DP[i], DP[j*j] + DP[i - j *j])
        j+=1
print(DP[N])