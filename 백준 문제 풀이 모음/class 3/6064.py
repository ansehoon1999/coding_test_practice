# import sys

# T = int(sys.stdin.readline())

# for _ in range(T) :
#     m, n, x, y = map(int, sys.stdin.readline().split())

#     small = min(x,y)

#     x = x - small
#     y = y - small

#     if x == 0 :
#         i = 0 
#         while True :
#             i += 1
#             tmp = y + i * n
#             state = tmp  % m            

#             if tmp > m * n :
#                 print(-1)
#                 break
#             if state == 0 :
#                 print(tmp + small)
#                 break
            
        
#     elif y == 0 :
#         i = 0
#         while True :
#             i += 1
#             tmp = x + i * m
#             state = tmp % n

#             if tmp > m * n :
#                 print(-1)
#                 break
#             if state == 0 :
#                 print(tmp + small)
#                 break

def num(m, n, x, y):
    while x <= m * n:
        if (x - y) % n == 0:
            return x
        x += m
    return -1

t = int(input())
for i in range(t):
    m, n, x, y = map(int, input().split())
    print(num(m, n, x, y))