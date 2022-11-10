
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

# for i in range(n+1) :
#     key = i
#     total = key
#     tmp = []
#     if primes[i] == 1 :
#         while True :
#             if i == n :
#                 break
#             i += 1
#             if primes[i] == 1 :
#                 total += i
#                 if total >= n :
#                     break
#                 count[total] += 1
#                 tmp.append(total)
#         print(key, tmp)
#     else :
#         continue
        
# # for i in range(len(count)) :
# #     print(i, count[i])

# # print(count[-1])
