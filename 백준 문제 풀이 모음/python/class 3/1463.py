# import sys

# n = int(sys.stdin.readline())

# count = {1: 0 , 2: 1}

# def make(n) :
#     if n in count :
#         return count[n]
    
#     cnt =  1 + min (make(n//3) + n %3, make(n//2) + n % 2)
#     count[n] = cnt
#     return cnt
    
# print(make(n))

n = int(input())
d = [0] * (n + 1)
before = [1] * (n + 1)	
for i in range(2, n + 1):
    d[i] = d[i - 1] + 1
    before[i] = i-1 
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)	
        if d[i] == d[i//3] + 1 :
            before[i] = i // 3
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
        if d[i] == d[i//2] + 1 :
            before[i] = i // 2


print(d[n])
i = n 
print(i, end = " ")
while True :
    if i == 1 :
        break

    i = before[i]
    print(i, end = " ")