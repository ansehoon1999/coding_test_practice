
# class stack() :
#     def __init__(self) :
#         self.stack = []

#     def push (self, data) :
#         self.stack.append(data)
    
#     def pop(self) :
#         self.stack.pop()
    
# import sys
# n = int(sys.stdin.readline())
# l = []

# result1 = []
# result2 = []

# for i in range(n) : #[4, 3, 6, 8, 7, 5, 2, 1]
#     l.append(int(sys.stdin.readline()))

#  #[4, 3, 6, 8, 7, 5, 2, 1]

# i = 1
# while True :
#     if i == n + 2 :
#         if len(l) == 0 :
#             finish = 'ok'
#         else :
#             finish = 'no'
        
#         break


    
#     if len(result1) == 0 :
#         result1.append(i)
#         result2.append('+')
#         i += 1
#         continue

#     if l[0] == result1[-1] :
#         l.pop(0)
#         result1.pop(-1)
#         result2.append('-')

#     elif l[0] != result1[-1] :
#         result1.append(i)
#         result2.append('+')
#         i += 1

# if finish == 'ok' :
#     for i in result2 :
#         print(i)
# else :
#     print('NO')
    

count = 1
stack = []
op = []
temp = True
import sys

N = int(sys.stdin.readline())
for i in range(N) :
    num = int(sys.stdin.readline())
    while count <= num :
        stack.append(count)
        op.append('+')
        count += 1
    
    if stack[-1] == num :
        stack.pop()
        op.append('-')
    
    else :
        temp = False
        break

if temp :
    for i in op :
        print(i)
else :
    print('NO')

