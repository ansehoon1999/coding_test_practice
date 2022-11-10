
import sys
n= int(sys.stdin.readline())
count = [0,0] + [1]*(n-1)
primes = []
for i in range(2,n+1):
  if count[i] == 1:
    primes.append(i)
    for j in range(2*i, n+1, i):
        count[j] = 0

for i in range(len(primes)-1) :
    total = primes[i]
    for j in range(i+1, len(primes)) :
        total += primes[j]
        if total > n :
            break
        
        count[total] += 1       
print(count[-1])

