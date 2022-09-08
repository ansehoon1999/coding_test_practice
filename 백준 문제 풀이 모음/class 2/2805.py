from re import T
import sys

N, M = map(int, sys.stdin.readline().split())
l = list(map(int, sys.stdin.readline().split()))

right = max(l)
left = 1

while left <= right :
    mid = (left + right) // 2
    count = 0
    for i in range(len(l)) :
        if l[i] - mid > 0 :
            count = count + (l[i] - mid)
    
    if M > count :
        right = mid -1
    elif M <= count :
        left = mid +1

        
print(right)
        

